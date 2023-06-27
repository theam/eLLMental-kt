package com.theagilemonkeys.llmental.core.handler

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class HandlerTest : BehaviorSpec({

    Given("a Handler") {
        When("I initialize it with an input and output type") {
            Then("it should have a name") {
                val sut = handler<String, Int> { s -> s.length }
                sut.name shouldBe "StringToInt"
            }

            Then("it should allow me to set a custom name") {
                val sut2 = handler<String, Int>("MyCustomName"){ s ->
                    s.length
                }
                sut2.name shouldBe "MyCustomName"
            }
        }
    }

})
