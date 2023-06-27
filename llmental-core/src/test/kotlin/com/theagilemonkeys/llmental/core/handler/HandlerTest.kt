package com.theagilemonkeys.llmental.core.handler

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class HandlerTest : BehaviorSpec({

    Given("a single Handler") {
        When("I initialize it with an input and output type") {
            Then("it should have a name") {
                val sut = handler<String, Int> { s -> s.length }
                sut.name shouldBe "StringToInt"
            }

            Then("it should allow me to set a custom name") {
                val sut2 = handler<String, Int>("MyCustomName") { s ->
                    s.length
                }
                sut2.name shouldBe "MyCustomName"
            }
        }

        When("I initialize with some logic") {
            Then("I can run it as if it was a function") {
                val sut = handler<String, Int> { s -> s.length }
                sut("Hello") shouldBe 5
            }
        }

    }

    Given("two handlers") {
        When("one uses another") {
            Then("they should appear in the dependency tree of the other") {
                val handler1 = handler<String, Int> { s ->
                    s.length
                }
                val handler2 = handler<Int, Int> { i ->
                    val foo = handler1("Hello")
                    foo + i
                }
                val result = handler2(5)
                result shouldBe 10
                handler2.uses shouldBe setOf(handler1)
                handler1.usedBy shouldBe setOf(handler2)
            }
        }
    }

})
