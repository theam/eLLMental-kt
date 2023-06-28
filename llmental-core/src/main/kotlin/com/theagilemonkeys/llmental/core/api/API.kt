package com.theagilemonkeys.llmental.core.api

import com.theagilemonkeys.llmental.core.Mandatory
import com.theagilemonkeys.llmental.core.PrimitiveModule
import com.theagilemonkeys.llmental.core.handler.Handler
import com.theagilemonkeys.llmental.core.makeDsl

class API(
    @Mandatory val name: String
) : PrimitiveModule() {
    var writeOperations = mutableMapOf<String, Handler<Any, Any>>()
    var readOperations = mutableMapOf<String, Handler<Any, Any>>()


    fun getName(operationName: String) = "$name.$operationName"

    fun <I : Any, O : Any> write(
        handler: Handler<I, O>
    ) {
        @Suppress("UNCHECKED_CAST")
        writeOperations[handler.name] = handler as Handler<Any, Any>
    }

    fun <I : Any, O : Any> read(
        handler: Handler<I, O>
    ) {
        @Suppress("UNCHECKED_CAST")
        readOperations[handler.name] = handler as Handler<Any, Any>
    }
}

fun api(name: String, block: API.() -> Unit): API =
    makeDsl(API(name), block)
