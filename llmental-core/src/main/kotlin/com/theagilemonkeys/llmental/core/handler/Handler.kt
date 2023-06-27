package com.theagilemonkeys.llmental.core.handler

import com.theagilemonkeys.llmental.core.Mandatory
import com.theagilemonkeys.llmental.core.PrimitiveModule
import kotlin.concurrent.getOrSet
import kotlin.reflect.KClass

/**
 * Handler class that represents a unit of computation that can be deployed and run
 * in a remote infrastructure.
 *
 * Notes:
 * - The access to context like third party services, database, is defined via the `use` function in other modules
 * - The errors that it can throw are handled by Kotlin `suspend` capabilities. Errors must implement Throwable
 * - The input and output types are defined explicitly.
 *
 * Given that it is executed in a distributed system, we assume that the code will
 * perform side effects, even if it is pure.
 */
class Handler<I : Any, O : Any>(
    @Mandatory val name: String,
    @Mandatory val inputType: KClass<I>,
    @Mandatory val outputType: KClass<O>,
    @Mandatory val block: HandlerBlock<I, O>,
) : PrimitiveModule() {


    /**
     * The invoke operator allows executing the handler as if it was a regular function.
     *
     * It will add the handler to the dependency tree of the caller, and it will set the
     * caller as the current caller of the handler.
     */
    suspend operator fun invoke(input: I): O {
        // We get the current caller from the ThreadLocal and we add the handler to the
        // dependency tree of the caller.
        currentCaller.get()?.let { caller ->
            caller.uses.add(this)
            this.usedBy.add(caller)
        }
        // We save the old caller in order to restore it later.
        val oldCaller = currentCaller.getOrSet { this }
        // We set the current caller to the handler and we execute the block.
        currentCaller.set(this)
        return block(input).also {
            // We restore the old caller.
            currentCaller.set(oldCaller)
        }
    }
}

/**
 * Type alias for the block we're passing to the handler function.
 *
 * Conceptually, it is a function like
 *
 * I -> IO<Either<Throwable, O>>
 *
 * But we're using the suspend capability to handle the errors, as
 * Kotlin will handle them automatically for us as long as they are
 * `Throwable`s.
 */
typealias HandlerBlock<I, O> = suspend Handler<I, O>.(I) -> O

/**
 * Helper function to create the DSL block for the handler.
 * We're not using the `makeDsl` function because we want to
 * have the `inline` capability here in order to reflect on the
 * input and output types.
 *
 * By default, we make the name of the handler to be the concatenation of the input and output types.
 *
 * This is useful to provide a better developer experience when using the DSL, as it is not mandatory
 * to set the name of the handler.
 *
 * For example, if we have a handler that converts a `String` to an `Int`, the name of the handler
 * will be `StringToInt`.
 *
 * This can be changed by setting the name like this:
 *
 * ```kotlin
 * val handler = handler("MyCustomName"){ input: String ->
 *     input.toInt()
 * }
 * ```
 */
inline fun <reified I : Any, reified O : Any> handler(
    crossinline handle: HandlerBlock<I, O>,
): Handler<I, O> {
    val defaultName = "${I::class.simpleName}To${O::class.simpleName}"
    return handler(defaultName, handle)
}

/**
 * Helper function to create a named handler. Same as the previous one,
 * but it allows to set a custom name.
 */
inline fun <reified I : Any, reified O : Any> handler(
    name: String,
    crossinline handle: HandlerBlock<I, O>,
): Handler<I, O> {
    val result = Handler(name, I::class, O::class) { handle(it) }
    result.create()
    return result
}
