package com.theagilemonkeys.llmental.core.api

import kotlin.reflect.KClass

class API<Ctx : Any>(
    private val service: KClass<Ctx>
) {
    var writeOperations = mutableMapOf<String, Handler<Any, Any>>()
    var readOperations = mutableMapOf<String, Handler<Any, Any>>()


    @Suppress("UNCHECKED_CAST")
    fun define(
        methodName: String,
    ): HandlerBuilder<Any, Any> {
        val method = service.members.find { it.name == methodName }
            ?: throw IllegalArgumentException(
                "Method $methodName not found in service ${service.simpleName}"
            )
        val inputType = method.parameters[1].type.classifier as KClass<Any>
        val outputType = method.returnType.classifier as KClass<Any>
        val block = { input: Any ->
            method.call(input) as Any
        }
        return HandlerBuilder(methodName, inputType, outputType, block)
    }
}


sealed class OperationMode
object Read : OperationMode()
object Write : OperationMode()

data class Handler<I : Any, O : Any>(
    val name: String,
    val inputType: KClass<I>,
    val outputType: KClass<O>,
    val handler: suspend (I) -> O,
    val operationMode: OperationMode
)

data class HandlerBuilder<I : Any, O : Any>(
    val name: String,
    val inputType: KClass<I>,
    val outputType: KClass<O>,
    val handler: suspend (I) -> O
) {
    context(API<Ctx>)
    @Suppress("UNCHECKED_CAST")
    infix fun <Ctx : Any> like(mode: OperationMode) {
        val thisAPI = this@API
        val handler = Handler(
            name,
            inputType,
            outputType,
            handler,
            mode
        )
        when (mode) {
            is Read -> thisAPI.readOperations[handler.name] = handler as Handler<Any, Any>
            is Write -> thisAPI.writeOperations[handler.name] = handler as Handler<Any, Any>
        }
    }
}

fun <Ctx : Any> KClass<Ctx>.apiDefinition(init: API<Ctx>.() -> Unit): API<Ctx> {
    val service = this@KClass
    val api = API(service)
    api.init()
    return api
}

