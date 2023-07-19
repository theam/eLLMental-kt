package com.theagilemonkeys.ellmental.embeddingsmodel.openai

import com.aallam.openai.api.embedding.EmbeddingRequest
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.theagilemonkeys.ellmental.core.schema.Embedding
import com.theagilemonkeys.ellmental.embeddingsmodel.EmbeddingsModel

private const val EMBEDDING_MODEL_ID = "text-embedding-ada-002"

/**
 * # OpenAI Embeddings Model
 *
 * Concrete implementation of [EmbeddingsModel] that uses the OpenAI API to embed text.
 * It doesn't use any additional parameters.
 *
 * @see EmbeddingsModel
 */
context(OpenAI)
class OpenAIEmbeddingsModel : EmbeddingsModel<Any> {

    /**
     * Embeds the given text into a vector space.
     *
     * @param text The text to embed.
     * @param params - ignored
     * @return An [Embedding] object containing the embedding vector.
     * @throws IllegalStateException if the response is empty.
     */
    override suspend fun embed(text: String, params: Any?): Embedding {
        val request = EmbeddingRequest(
            model = ModelId(EMBEDDING_MODEL_ID),
            input = listOf(text)
        )
        val result = embeddings(request)
        check(result.embeddings.isNotEmpty()) {
            "Expected exactly 1 embedding, got ${result.embeddings.count()}"
        }
        return Embedding(result.embeddings[0].embedding)
    }
}
