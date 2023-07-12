package com.theagilemonkeys.ellmental.core.api

import io.kotest.common.runBlocking
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

class ApiTest : BehaviorSpec({

    /**
     * Class under test
     */
    class MockService {
        fun writeOp(name: String): String {
            return "Hello $name"
        }

        fun readOp(name: String): String {
            return "Goodbye $name"
        }
    }

    Given("the API DSL") {
        When("I define write operations") {
            Then("I can get the name of the operation correctly") {
                checkAll { operationName: String ->
                    with(MockService()) {
                        val api = MockService::class.apiDefinition {
                            write(operationName) { input: String ->
                                writeOp(input)
                            }
                        }

                        api.writeOperations[operationName]?.name shouldBe operationName
                    }


                }
            }

            Then("I can execute the handler of the operation") {
                checkAll { operationName: String, input: String ->

                    with(MockService()) {
                        val api = MockService::class.apiDefinition {
                            write(operationName) { input: String ->
                                writeOp(input)
                            }
                        }

                        val handler = api.writeOperations[operationName] ?: error("Handler not found")

                        val result = runBlocking { handler.handler(input) }

                        result shouldBe "Hello $input"
                    }
                }
            }
        }

        When("I define read operations") {
            Then("I can get the name of the operation correctly") {
                checkAll { operationName: String ->
                    with(MockService()) {
                        val api = MockService::class.apiDefinition {
                            read(operationName) { input: String ->
                                readOp(input)
                            }
                        }

                        api.readOperations[operationName]?.name shouldBe operationName
                    }
                }
            }

            Then("I can execute the handler of the operation") {
                checkAll { operationName: String, input: String ->

                    with(MockService()) {
                        val api = MockService::class.apiDefinition {
                            read(operationName) { input: String ->
                                readOp(input)
                            }
                        }

                        val handler = api.readOperations[operationName] ?: error("Handler not found")

                        val result = runBlocking { handler.handler(input) }

                        result shouldBe "Goodbye $input"
                    }

                }
            }
        }
    }

})
