package org.theagilemonkeys.llmental.service.semanticSearch

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder

class SemanticSearchTest : StringSpec({
    val semanticSearch = SemanticSearch()

    "Learning a new text should return true" {
        val text = "This is a test sentence."
        val entry = SemanticEntry(text, mapOf("testKey" to "testValue"))
        val result = semanticSearch.learn(entry)
        result.shouldBeTrue()
    }

    "Searching for a learned text should return the text's metadata" {
        val text = "This is a test sentence."
        val entry = SemanticEntry(text, mapOf("testKey" to "testValue"))
        semanticSearch.learn(entry)

        val searchResult = semanticSearch.search(text)
        searchResult.shouldContainExactlyInAnyOrder(listOf(entry))
    }
})
