package com.theagilemonkeys.llmental.semanticsearch

import com.theagilemonkeys.llmental.core.schema.SemanticEntry
import com.theagilemonkeys.llmental.semanticsearch.learn.learn
import io.kotest.common.runBlocking
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.string.shouldMatch
import io.kotest.property.checkAll

class OperationsTest : BehaviorSpec({

    Given("The SemanticSearch module") {
        When("I run the learn operation") {
            Then("I should get back an ID") {
                checkAll<SemanticEntry> { entry ->
                    val result = runBlocking { learn()(entry) }
                    val uuidRegex =
                        "^[0-9a-fA-F]{8}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{4}\\b-[0-9a-fA-F]{12}\$"
                    result.shouldMatch(uuidRegex)
                }
            }
        }
    }

})
