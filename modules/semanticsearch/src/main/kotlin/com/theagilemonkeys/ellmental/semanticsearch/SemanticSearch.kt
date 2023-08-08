package com.theagilemonkeys.ellmental.semanticsearch

import com.theagilemonkeys.ellmental.core.schema.SemanticEntry
import com.theagilemonkeys.ellmental.core.schema.SemanticEntryMatch
import com.theagilemonkeys.ellmental.embeddingsmodel.EmbeddingsModel
import com.theagilemonkeys.ellmental.vectorstore.VectorStore
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
     * "Learns" a list of texts to make them available in future semantic searches. It uses the
     * [EmbeddingsModel] to calculate text embeddings for each piece of text. Then it uses the
     * [VectorStore] to persist them.
     *
     * @param input A list of texts to be learned.
     */
    suspend fun learn(input: LearnInput) =
        input.data.forEach { data ->
            check(data.text.isNotBlank()) { "Text cannot be blank" }
            val embedding = embed(data.text)
            val semanticEntry = SemanticEntry(content = data.text, embedding = embedding, metadata = data.metadata)
            upsert(semanticEntry)
        }

    /**
     * Performs a semantic search operation using the provided text as reference. It will look for
     * texts stored in the [VectorStore] that are "semantically close" to the provided one and return
     * a ranked list of results.
     *
     * @param text The text to be used as reference for semantic search.
     * @param itemsLimit The maximum number of results to return.
     * @return A list of semantically similar texts ranked by semantic distance (the closest first).
     */
    suspend fun search(text: String, itemsLimit: Int): SearchOutput {
        check(text.isNotBlank()) { "Text cannot be blank" }
        val embedding = embed(text)
        val semanticEntry = SemanticEntry(content = text, embedding = embedding)
        return SearchOutput(query(semanticEntry, itemsLimit).entries)
    }
}


@Serializable
data class Data(
    val text: String,
    val metadata: Map<String, String>? = null
)

@Serializable
data class LearnInput(val data: List<Data>)

@Serializable
data class SearchOutput(val entries: List<SemanticEntryMatch>)
