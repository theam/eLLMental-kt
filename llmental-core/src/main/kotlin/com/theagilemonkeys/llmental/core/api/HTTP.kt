@file:Suppress("WildcardImport")

package com.theagilemonkeys.llmental.core.api


import com.theagilemonkeys.llmental.core.handler.Handler
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import org.http4k.core.*
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Http4kServer
import org.http4k.server.KtorCIO
import org.http4k.server.asServer
import kotlin.reflect.KClass

fun API.toHttpApp(port: Int = 9000): Http4kServer {
    fun runHandler(input: Any, handler: Handler<Any, Any>): Response =
        try {
            // This will run the handler blocking ONLY IN THE CURRENT THREAD
            // which is the one of this current endpoint. Http4k will handle
            // the concurrency for us with their own thread handling mechanism.
            val result = runBlocking {
                handler(input)
            }
            val output = Json.encodeToString(handler.outputType.toSerializer(), result)
            Response(OK).body(output)
        } catch (expectedException: Exception) {
            Response(Status.INTERNAL_SERVER_ERROR).body(expectedException.message ?: "Unknown error")
        }

    fun toPost(handler: Handler<Any, Any>): RoutingHttpHandler =
        "/${handler.name}" bind Method.POST to { request: Request ->
            try {
                val input = Json.decodeFromString(
                    handler.inputType.toSerializer(), request.bodyString()
                )
                runHandler(input, handler)
            } catch (expectedException: Exception) {
                Response(Status.BAD_REQUEST).body(expectedException.message ?: "Unknown error")
            }
        }

    fun toGet(handler: Handler<Any, Any>): RoutingHttpHandler =
        "/${handler.name}" bind Method.GET to { req: Request ->
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


    val writeRoutes = writeOperations.map { toPost(it.value) }
    val readRoutes = readOperations.map { toGet(it.value) }
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
