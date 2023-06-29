package com.theagilemonkeys.llmental.core.api

import com.theagilemonkeys.llmental.core.handler.Handler
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.queries
import org.http4k.routing.RoutingHttpHandler
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Http4kServer
import org.http4k.server.KtorCIO
import org.http4k.server.asServer
import kotlin.reflect.KClass

fun API.toHttpApp(port: Int = 9000): Http4kServer {
    fun runHandler(input: Any, handler: Handler<Any, Any>): Response {
        // This will run the handler blocking ONLY IN THE CURRENT THREAD
        // which is the one of this current endpoint. Http4k will handle
        // the concurrency for us with their own thread handling mechanism.
        val result = runBlocking {
            handler(input)
        }
        val output = Json.encodeToString(handler.outputType.toSerializer(), result)
        return Response(OK).body(output)
    }

    fun <T : Any> KClass<T>.fromQueryParams(queryParams: Map<String, String>): T {
        val constructor = this.constructors.first()

        val parameters = constructor.parameters.associateWith { parameter ->
            val value = queryParams[parameter.name]
            val serializer = parameter.type.classifier as? KSerializer<*>

            when (serializer) {
                String.serializer() -> value
                Int.serializer() -> value?.toInt()
                Long.serializer() -> value?.toLong()
                Double.serializer() -> value?.toDouble()
                Boolean.serializer() -> value?.toBoolean()
                else -> throw IllegalArgumentException("Unsupported type: ${parameter.type}")
            }
        }

        return constructor.callBy(parameters)
    }


    fun toPost(handler: Handler<Any, Any>): RoutingHttpHandler =
        "/${handler.name}" bind Method.POST to { request: Request ->
            val input = Json.decodeFromString(
                handler.inputType.toSerializer(), request.bodyString()
            )
            runHandler(input, handler)
        }

    fun toGet(handler: Handler<Any, Any>): RoutingHttpHandler =
        "/${handler.name}" bind Method.GET to { req: Request ->
            val queryParams = req.uri.queries().toMap().mapValues { it.value ?: "" }
            val input = handler.inputType.fromQueryParams(queryParams)
            runHandler(input, handler)
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
