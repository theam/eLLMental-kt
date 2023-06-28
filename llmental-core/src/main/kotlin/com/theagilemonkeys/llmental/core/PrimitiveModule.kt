package com.theagilemonkeys.llmental.core

import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
import kotlin.reflect.safeCast


/**
 * PrimitiveModule is the base class for all the modules that can be used
 * in the DSL.
 *
 * It manages a double-linked tree of dependencies between modules, so each
 * module knows the caller and the modules it is using.
 *
 * This is useful to provide a good developer experience while using the DSL,
 * as it can check at compile time if all the mandatory parameters are set.
 *
 */
open class PrimitiveModule {

    /**
     * The id of the module. By default, it is a random UUID.
     */
    var id: String = java.util.UUID.randomUUID().toString()

    /**
     * Tree of who is using this module. Used to resolve dependencies and
     * authorize the usage of them by others.
     */
    val usedBy = mutableSetOf<PrimitiveModule>()

    /**
     * Tree of who is used by this module. Used to resolve dependencies and
     * authorize the usage of them by others.
     */
    val uses = mutableSetOf<PrimitiveModule>()

    /**
     * The SDK instance. It is set by the `InfrastructureManager` when the
     * module is deployed. It is used to provide an API to the modules so
     * they know how to deploy themselves without being coupled to the
     * infrastructure.
     */
    lateinit var sdk: InfrastructureManager

    /**
     * This is a singleton object that it is used in order to know the
     * current caller of the module. It is used to build the tree of
     * dependencies between modules.
     *
     * It uses a `ThreadLocal` to store the current caller in order to
     * be able to retrieve the caller later in the execution flow.
     */
    companion object {
        @JvmStatic
        protected val currentCaller = ThreadLocal<PrimitiveModule>()
    }

    /**
     * This method is used to mark a module as used by the current caller.
     *
     * It is equivalent to an import in a traditional programming language.
     */
    open fun <T : PrimitiveModule> use(module: T) {
        // Set the ThreadLocal variable to the current caller
        currentCaller.set(this)
    }

    /**
     * This method is called when the module is created. It is used to
     * initialize the module. It will check if all the mandatory parameters
     * are set, and then call the `onCreate` method, which can be overridden
     * by the modules to provide their own initialization logic.
     */
    fun create() {
        checkMandatoryParams()
        onCreate()
    }

    /**
     * This method is called when the module is deployed. It is used to
     * deploy the module to the infrastructure as indicated by the InfrastructureManager.
     */
    suspend fun deploy() {
        // SDK will be added at the top level of the program, so it is not considered
        // a mandatory parameter until the module is deployed.
        check(::sdk.isInitialized) { "sdk is not initialized" }

        // We check again the mandatory parameters, as they could have been set
        // after the module was created.
        checkMandatoryParams()

        // TO DO: Actually implement the deployment logic
        println("Deploying module ${this::class.simpleName} with id $id")
    }

    /**
     * This method is called after the module is created. It can be overridden
     * by the modules to provide their own initialization logic.
     */
    protected open fun onCreate() {
        // Default empty implementation
    }

    /**
     * This method is used to check if all the mandatory parameters are set.
     * If not, it will throw an exception right at the moment of the module
     * creation phase, which is at the beginning of the program execution.
     */
    private fun checkMandatoryParams() {
        // We go through all the member properties of the class, and check if
        // they are annotated with the `Mandatory` annotation. If so, we check
        // if they are initialized. If not, we throw an exception.
        this::class.memberProperties.forEach { prop ->
            if (!prop.annotations.any { it is Mandatory }) return@forEach
            if (isPropertyInitialized(this, prop)) return@forEach
            error("Mandatory parameter ${prop.name} is not set")
        }
    }

    /**
     * This method is used to check if a property is initialized. It is used
     * to avoid passing the class constantly, as it is not available in the
     * `KProperty` class.
     */
    private fun <T : Any> isPropertyInitialized(instance: T, property: KProperty<*>): Boolean {
        return isPropertyInitialized(instance, property, instance::class)
    }

    /**
     * Actual implementation of the `isPropertyInitialized` method.
     *
     * Uses the `KClass` to check if the property is initialized.
     */
    private fun <T : Any, T2 : T> isPropertyInitialized(
        instance: T,
        property: KProperty<*>,
        type: KClass<T2>,
    ): Boolean {
        // We cast the instance to the type of the class. If it doesn't work
        // it means that the property is not initialized, so we return false
        val instanceCast = type.safeCast(instance) ?: return false

        // We perform a try/catch here, as `get` can throw when the property
        // is not initialized.
        return try {
            // This is some "happy" casting, so the compiler will warn us
            // if the property is not a `KProperty1` of the type of the class.
            // We suppress it, as we are getting it from the `KProperty` class
            // in the `checkMandatoryParams` method.
            @Suppress("UNCHECKED_CAST")
            (property as KProperty1<T2, *>).get(instanceCast)

            // `get` didn't throw, so the property is initialized
            true
        } catch (_: UninitializedPropertyAccessException) {
            // `get` threw, so the property is not initialized
            false
        }
    }
}

/**
 * Used to add an `InfrastructureManager` as the deployment SDK for the module tree.
 * This means that if we add an SDK for AWS (for example), all the module tree will
 * be able to use it to deploy themselves.
 */
fun <T : PrimitiveModule> T.withSdk(sdk: InfrastructureManager): T {
    // Set the current module's SDK
    this.sdk = sdk

    // Set the SDK to all the modules that are using this one
    uses.forEach {
        it.withSdk(sdk)
    }

    // Return as if it is a fluent API
    return this
}

/**
 * Used to create a DSL block for a module, making the module available in the context
 * of the block.
 *
 * For example, in a possible HTTP module, we could define methods to define routes
 * in the module class, and then use `makeDsl` to make the module available in the
 * context of the block:
 *
 * ```kotlin
 * class HttpApi : PrimitiveModule() {
 *     fun get()
 *     fun post()
 *     fun put()
 *     fun delete()
 * }
 *
 * fun httpapi(init: HttpApi.() -> Unit): HttpApi =
 *    makeDsl(HttpApi(), init)
 * ```
 *
 * This would allow us to define routes in the DSL block:
 *
 * ```kotlin
 * httpapi {
 *    get("/hello") {
 *    // ...
 *    }
 *
 *    post("/hello") {
 *    // ...
 *    }
 *
 *    // And so on
 * }
 * ```
 *
 * It will call the block with the module instance as the receiver, so we can
 * access the module's methods and properties directly. After that it will call
 * the `create` method of the module, which will check if all the mandatory
 * parameters are set, and then return the module instance with all dependencies
 * and parameters set, which is set in the block by using the `use` method.
 *
 * This instance then can be used to be deployed to the infrastructure or whatever
 * thing we want to do with it, like generating a UI from it.
 */
fun <T : PrimitiveModule> makeDsl(moduleInstance: T, init: T.() -> Unit): T {
    moduleInstance.init()
    moduleInstance.create()
    return moduleInstance
}