package com.theagilemonkeys.llmental.core.handler

import com.theagilemonkeys.llmental.core.Mandatory
import com.theagilemonkeys.llmental.core.PrimitiveModule
import kotlin.concurrent.getOrSet
import kotlin.reflect.KClass

/**
 * Handler class that represents a unit of computation that can be deployed
 */
class Handler<I : Any, O : Any>(
    @Mandatory val inputType: KClass<I>,
    @Mandatory val outputType: KClass<O>,
    @Mandatory val block: HandlerBlock<I, O>,
) : PrimitiveModule() {

    @Mandatory
    var name: String = "${inputType.simpleName}To${outputType.simpleName}"

    suspend operator fun invoke(input: I): O {
        currentCaller.get()?.let { caller ->
            caller.uses.add(this)
            this.usedBy.add(caller)
        }
        val oldCaller = currentCaller.getOrSet { this }
        currentCaller.set(this)
        return block(input).also {
            currentCaller.set(oldCaller)
        }
    }
}

typealias HandlerBlock<I, O> = suspend Handler<I, O>.(I) -> O

inline fun <reified I : Any, reified O : Any> handler(
    crossinline handle: HandlerBlock<I, O>,
): Handler<I, O> {
    return Handler(I::class, O::class) { handle(it) }
}
