package com.theagilemonkeys.ellmental.semanticsearchservicedemo

import com.theagilemonkeys.ellmental.core.api.API
import com.theagilemonkeys.ellmental.core.api.apiDefinition
import com.theagilemonkeys.ellmental.core.api.runHttp
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIClient
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel
import com.theagilemonkeys.ellmental.semanticsearch.SearchInput
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore
import io.github.cdimascio.dotenv.dotenv
import kotlinx.coroutines.runBlocking

/**
 * Demo configuration of the Semantic Search Service.
 *
 * Uses:
 *  * OpenAI's embeddings model
 *  * Pinecone as vector store
 *  * HTTP as API
 *
 */
fun buildApi(): API<SemanticSearch> {
    val envDir = System.getenv("DEBUG_DOTENV")?.trim().let {
        if (it.isNullOrBlank()) "."
        else it
    }
    val env = dotenv {
        directory = envDir
        ignoreIfMalformed = true
        ignoreIfMissing = true
    }
    val openaiToken = env["OPEN_AI_API_KEY"].let {
        check(it != null && it.trim().isNotBlank()) {
            "OPEN_AI_API_KEY environment variable not set: $it"
        }
        it
    }
    val pineconeToken = env["PINECONE_API_KEY"].let {
        check(it != null && it.trim().isNotBlank()) {
            "PINECONE_API_KEY environment variable not set"
        }
        it
    }
    val pineconeUrl = env["PINECONE_URL"].let {
        check(it != null && it.trim().isNotBlank()) {
            "PINECONE_URL environment variable not set"
        }
        it
    }

    with(OpenAIClient(apiKey = openaiToken)) {
        with(OpenAIEmbeddingsModel()) {
            with(PineconeVectorStore(apiKey = pineconeToken, url = pineconeUrl)) {
                with(SemanticSearch()) {
                    val api = SemanticSearch::class.apiDefinition {
                        write("learn") { s: SearchInput -> learn(s) }
                        read("search") { s: String -> search(s) }
                    }

                    return api
                }
            }
        }
    }
}


/**
 * This is a demo of the Semantic Search Service using:
 *   * OpenAI's embeddings model
 *   * Pinecone as vector store
 *
 * It will start a server on port 8080 with the following endpoints:
 * - POST /learn
 * - POST /search
 */
fun main(): Unit = runBlocking {
    buildApi().runHttp(port = 8080)
}
