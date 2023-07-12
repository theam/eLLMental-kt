package com.theagilemonkeys.llmental.semanticsearch

import com.aallam.openai.client.OpenAI
import com.theagilemonkeys.llmental.core.api.apiDefinition
import com.theagilemonkeys.llmental.core.schema.SemanticEntry
import com.theagilemonkeys.llmental.embeddingsModel.EmbeddingsModel
import com.theagilemonkeys.llmental.embeddingsModel.openai.OpenAIEmbeddingsModel
import com.theagilemonkeys.llmental.vectorStore.VectorStore
import com.theagilemonkeys.llmental.vectorStore.pinecone.PineconeVectorStore
import io.github.cdimascio.dotenv.dotenv
import kotlinx.serialization.Serializable

@Serializable
data class SearchInput(
    val texts: List<String>
)

@Serializable
data class SearchOutput(
    val entries: List<SemanticEntry>
)

context(EmbeddingsModel<Any>, VectorStore)
class SemanticSearch {
    suspend fun learn(input: SearchInput) = input.texts.forEach { text ->
        check(text.isNotBlank()) { "Text cannot be blank" }
        val embedding = embed(text)
        val semanticEntry = SemanticEntry(embedding = embedding)
        upsert(semanticEntry)
    }

    suspend fun search(text: String): SearchOutput {
        check(text.isNotBlank()) { "Text cannot be blank" }
        val embedding = embed(text)
        val semanticEntry = SemanticEntry(embedding = embedding)
        return SearchOutput(query(semanticEntry).entries)
    }

    /**
     * The default API definition for the Semantic Search Service.
     */
    val api = SemanticSearch::class.apiDefinition {
        write("learn") { s: SearchInput -> learn(s) }
        read("search") { s: String -> search(s) }
    }


    /**
     * Default, hassle-free, implementation of the Semantic Search Service.
     *
     * Uses:
     *  * OpenAI's embeddings model
     *  * Pinecone as vector store
     *  * HTTP as API
     *
     *  Usage:
     *
     *  SemanticSearch.default()
     */
    companion object {
        @Suppress("NestedBlockDepth")
        fun default(): SemanticSearch {
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

            with(OpenAI(token = openaiToken)) {
                with(OpenAIEmbeddingsModel()) {
                    with(PineconeVectorStore(apiKey = pineconeToken, url = pineconeUrl)) {
                        with(SemanticSearch()) {
                            return this
                        }
                    }
                }
            }
        }

    }
}

