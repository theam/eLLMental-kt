package com.theagilemonkeys.ellmental.semanticsearch

import com.aallam.openai.client.OpenAI
import com.theagilemonkeys.ellmental.core.api.apiDefinition
import com.theagilemonkeys.ellmental.core.schema.SemanticEntry
import com.theagilemonkeys.ellmental.embeddingsmodel.EmbeddingsModel
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel
import com.theagilemonkeys.ellmental.vectorstore.VectorStore
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore
import io.github.cdimascio.dotenv.dotenv
import kotlinx.serialization.Serializable

context(EmbeddingsModel<Any>, VectorStore)
/**
 * # Semantic Search
 *
 * The Semantic Search component allows you to index and search for semantically similar texts.
 * Under the hoods, it uses the Embeddings Model and the Vector Store modules.
 */
class SemanticSearch {

    /**
     * Stores a list of texts into the module.
     *
     * @param input A list of texts to be stored.
     */
    suspend fun learn(input: SearchInput) = input.texts.forEach { text ->
        check(text.isNotBlank()) { "Text cannot be blank" }
        val embedding = embed(text)
        val semanticEntry = SemanticEntry(embedding = embedding)
        upsert(semanticEntry)
    }

    /**
     * Performs a semantic search operation using the provided text as reference. It will look for texts stored in the [VectorStore] that are "semantically close" to the provided one and return a ranked list of results.
     *
     * @param text The text to be used as reference for semantic search.
     * @return A list of semantically similar texts ranked by semantic distance (the closest first).
     */
    suspend fun search(text: String): SearchOutput {
        check(text.isNotBlank()) { "Text cannot be blank" }
        val embedding = embed(text)
        val semanticEntry = SemanticEntry(embedding = embedding)
        return SearchOutput(query(semanticEntry).entries)
    }

    /**
     * The default API definition for the Semantic Search Service.
     *
     * @deprecated - API definition will be moved out of the repo in the future
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
     *
     *  @deprecated - API definition will be moved out of the repo in the future
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

@Serializable
data class SearchInput(
    val texts: List<String>
)

@Serializable
data class SearchOutput(
    val entries: List<SemanticEntry>
)

