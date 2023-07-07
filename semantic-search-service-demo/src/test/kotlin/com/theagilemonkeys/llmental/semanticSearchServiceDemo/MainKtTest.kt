package com.theagilemonkeys.llmental.semanticSearchServiceDemo

import com.theagilemonkeys.llmental.core.api.toHttpApp
import com.theagilemonkeys.llmental.core.schema.Id
import com.theagilemonkeys.llmental.semanticsearch.SearchOutput
import com.theagilemonkeys.llmental.semanticsearch.SemanticSearch
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain
import kotlinx.serialization.json.Json.Default.decodeFromString
import org.http4k.client.JavaHttpClient
import org.http4k.core.Method
import org.http4k.core.Request

class MainKtTest : StringSpec({
    "It will fail if the string is blank" {
        val textToLearn = ""

        val server =
            SemanticSearch.default().api.toHttpApp().start()

        val client = JavaHttpClient()

        // Run the learn operation and ensure it was OK
        run {
            val learnUri = "http://localhost:${server.port()}/SemanticSearch/learn"
            val learnRequest = Request(Method.POST, learnUri)
                .body("\"$textToLearn\"")
            val learnResponse = client(learnRequest)
            learnResponse.status.code shouldBe 500
            learnResponse.bodyString() shouldContain "cannot be blank"
        }

        // Run the search operation and ensure it was OK
        run {
            val searchUri = "http://localhost:${server.port()}/SemanticSearch/search?String=%22$textToLearn%22"
            val searchRequest = Request(Method.GET, searchUri)
            val searchResponse = client(searchRequest)
            searchResponse.status.code shouldBe 500
            searchResponse.status.code shouldBe 500
            searchResponse.bodyString() shouldContain "cannot be blank"
        }


        server.stop()
    }



    "I can store a text in the Semantic Search Service and retrieve it" {
        val textToLearn = "Hello"

        val server =
            SemanticSearch.default().api.toHttpApp().start()

        val client = JavaHttpClient()

        // Run the learn operation and ensure it was OK
        val learnUri = "http://localhost:${server.port()}/SemanticSearch/learn"
        val learnRequest = Request(Method.POST, learnUri)
            .body("\"$textToLearn\"")
        val learnResponse = client(learnRequest)
        learnResponse.status.code shouldBe 200

        // Run the search operation and ensure it was OK
        val searchUri = "http://localhost:${server.port()}/SemanticSearch/search?String=%22$textToLearn%22"
        val searchRequest = Request(Method.GET, searchUri)
        val searchResponse = client(searchRequest)
        searchResponse.status.code shouldBe 200
        val bodyString = searchResponse.bodyString()
        bodyString shouldContain "entries"
        val entries = decodeFromString(SearchOutput.serializer(), bodyString).entries
        entries.size shouldBeGreaterThan 0
        entries.forEach {
            it.id shouldNotBe Id("")
            it.id shouldNotBe null
            it.embedding.value.size shouldBeGreaterThan 0
        }


        server.stop()
    }
})
