package com.theagilemonkeys.llmental.core.api

import com.theagilemonkeys.llmental.core.handler.handler
import io.kotest.common.runBlocking
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll

class ApiTest : BehaviorSpec({

    Given("the API DSL") {
        When("I define write operations") {
            Then("I can get the name of the operation correctly") {
                checkAll { apiName: String, operationName: String ->
                    val lengthHandler = handler<String, Int>(operationName) { s ->
                        s.length
                    }

                    val sut = api(apiName) {
                        write(lengthHandler)
                    }


                    sut.writeOperations[operationName]?.name shouldBe operationName

                }
            }

            Then("I can execute the handler of the operation") {
                checkAll { apiName: String, operationName: String, input: String ->
                    val lengthHandler = handler<String, Int>(operationName) { s ->
                        s.length
                    }

                    val sut = api(apiName) {
                        write(lengthHandler)
                    }

                    val handler = sut.writeOperations[operationName] ?: error("Handler not found")

                    val result = runBlocking { handler(input) }

                    result shouldBe input.length

                }
            }
        }

        When("I define read operations") {
            Then("I can get the name of the operation correctly") {
                checkAll { apiName: String, operationName: String ->
                    val lengthHandler = handler<String, Int>(operationName) { s ->
                        s.length
                    }

                    val sut = api(apiName) {
                        read(lengthHandler)
                    }


                    sut.readOperations[operationName]?.name shouldBe operationName

                }
            }

            Then("I can execute the handler of the operation") {
                checkAll { apiName: String, operationName: String, input: String ->
                    val lengthHandler = handler<String, Int>(operationName) { s ->
                        s.length
                    }

                    val sut = api(apiName) {
                        read(lengthHandler)
                    }

                    val handler = sut.readOperations[operationName] ?: error("Handler not found")

                    val result = runBlocking { handler(input) }

                    result shouldBe input.length

                }
            }
        }
    }

})
