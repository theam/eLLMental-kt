package com.theagilemonkeys.llmental.core.api

import kotlin.reflect.KClass
import kotlin.reflect.jvm.jvmName

context(Ctx)
class API<Ctx : Any>(
    private val service: KClass<Ctx>
) {
    var writeOperations = mutableMapOf<String, Handler<Any, Any>>()
    var readOperations = mutableMapOf<String, Handler<Any, Any>>()

    fun getName(): String = service.simpleName ?: service.qualifiedName ?: service.jvmName

    inline fun <reified I : Any, reified O : Any> write(
        name: String,
        noinline block: suspend (I) -> O
    ) {
        val handler = Handler(
            name, I::class, O::class, block
        )
        @Suppress("UNCHECKED_CAST")
        writeOperations[name] = handler as Handler<Any, Any>
    }

    inline fun <reified I : Any, reified O : Any> read(
        name: String,
        noinline block: suspend (I) -> O
    ) {
        val handler = Handler(
            name, I::class, O::class, block
        )
        @Suppress("UNCHECKED_CAST")
        readOperations[handler.name] = handler as Handler<Any, Any>
    }


}


data class Handler<I : Any, O : Any>(
    val name: String,
    val inputType: KClass<I>,
    val outputType: KClass<O>,
    val handler: suspend (I) -> O,
)

context(Ctx)
fun <Ctx : Any> KClass<Ctx>.apiDefinition(init: API<Ctx>.() -> Unit): API<Ctx> {
    val service = this@KClass
    val api = API(service)
    api.init()
    return api
}

