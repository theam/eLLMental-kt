@file:Suppress("WildcardImport")

package com.theagilemonkeys.llmental.core.api


import kotlinx.coroutines.runBlocking
import kotlinx.serialization.*
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import org.http4k.core.*
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Http4kServer
import org.http4k.server.KtorCIO
import org.http4k.server.asServer
import kotlin.reflect.KClass

fun <Ctx : Any> API<Ctx>.runHttp(port: Int = 9000) {
    val app = toHttpApp(port)
    app.start().block()
}

/**
 * Converts an API to an HTTP app that is runnable with [Http4kServer.start].
 *
 * @param port the port to run the server on
 */
fun <Ctx : Any> API<Ctx>.toHttpApp(port: Int = 9000): Http4kServer {

    val serviceName = this.getName()

    /**
     * Runs a handler with some input and returns a response.
     *
     * @param input the input to run the handler with
     * @param handler the handler to run
     * @return 200 OK with the output of the handler if everything went well,
     * 400 BAD REQUEST if the input could not be deserialized,
     * 500 INTERNAL SERVER ERROR if the handler threw an exception.
     */
    fun runHandler(input: Any, handler: Handler<Any, Any>): Response =
        try {
            // This will run the handler blocking ONLY IN THE CURRENT THREAD
            // which is the one of this current endpoint. Http4k will handle
            // the concurrency for us with their own thread handling mechanism.
            val result = runBlocking {
                handler.handler(input)
            }
            val output = Json.encodeToString(handler.outputType.toSerializer(), result)
            Response(OK).body(output)
        } catch (expectedError: Error) {
            Response(Status.INTERNAL_SERVER_ERROR).body(e.message ?: "Unknown error")
        } catch (e: SerializationException) {
            Response(Status.BAD_REQUEST).body(e.message ?: "Error serializing output")
        } catch (expectedException: Exception) {
            Response(Status.INTERNAL_SERVER_ERROR).body(expectedException.message ?: "Unknown error")
        }


    /**
     * Converts a handler to an HTTP endpoint that can be called with a POST request.
     * The input of the handler is expected to be in the body of the request.
     *
     * @param handler the handler to convert
     * @return an HTTP endpoint that can be called with a POST request
     */
    fun toPost(handler: Handler<Any, Any>): RoutingHttpHandler =
        "/$serviceName/${handler.name}" bind Method.POST to { request: Request ->
            try {
                val input = Json.decodeFromString(
                    handler.inputType.toSerializer(), request.bodyString()
                )
                runHandler(input, handler)
            } catch (expectedException: Exception) {
                Response(Status.BAD_REQUEST).body(expectedException.message ?: "Unknown error")
            }
        }

    /**
     * Converts a handler to an HTTP endpoint that can be called with a GET request.
     * The input of the handler is expected to be in the query parameters of the request.
     * If the input type is a primitive type, the query parameter name is the name of the type.
     *
     * For example for a handler with input type Int, the query parameter name is "Int".
     *
     * And will be called like this:
     *
     * http://localhost:9000/greet?Int=1
     *
     * If the input type is a data class, the query parameters are the properties of the data class.
     *
     * @param handler the handler to convert
     * @return an HTTP endpoint that can be called with a GET request
     */
    fun toGet(handler: Handler<Any, Any>): RoutingHttpHandler =
        "/$serviceName/${handler.name}" bind Method.GET to { req: Request ->
            try {
                val queryParams = req.uri.queries().toMap()
                val value = if (!handler.inputType.isData) {
                    queryParams[handler.inputType.simpleName]
                        ?: throw IllegalArgumentException("Missing query parameter ${handler.inputType.simpleName}")
                } else {
                    Json.encodeToString(queryParams)
                }
                val input = Json.decodeFromString(handler.inputType.toSerializer(), value)
                runHandler(input, handler)
            } catch (expectedException: Exception) {
                Response(Status.BAD_REQUEST).body(expectedException.message ?: "Unknown error")
            }
        }


    // Convert write operations to POST endpoints
    val writeRoutes = writeOperations.map { toPost(it.value) }

    // Convert read operations to GET endpoints
    val readRoutes = readOperations.map { toGet(it.value) }

    // Combine all endpoints
    val routesArray = writeRoutes + readRoutes

    val app = routes(list = routesArray.toTypedArray())
    return app.asServer(KtorCIO(port))

}

/**
 * Serialization utility for allowing to get the serializer of a class.
 *
 * You can use it like
 *
 * val outputSerializer = handler.outputType.toSerializer()
 * val jsonString = Json.encodeToString(outputSerializer, outputObject)
 */
@Suppress("UNCHECKED_CAST")
@OptIn(InternalSerializationApi::class)
fun <T : Any> KClass<T>.toSerializer(): KSerializer<T> =
    when (this) {
        String::class -> String.serializer()
        Int::class -> Int.serializer()
        Long::class -> Long.serializer()
        Double::class -> Double.serializer()
        Boolean::class -> Boolean.serializer()
        // Add other types as needed
        else -> runCatching { this.serializer() }.getOrElse {
            throw IllegalArgumentException("Class is not serializable: $this")
        }
    } as KSerializer<T>
