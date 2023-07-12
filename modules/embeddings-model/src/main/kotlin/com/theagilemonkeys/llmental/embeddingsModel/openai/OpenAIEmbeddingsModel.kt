package com.theagilemonkeys.llmental.embeddingsModel.openai

import com.aallam.openai.api.embedding.EmbeddingRequest
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.theagilemonkeys.llmental.core.schema.Embedding
import com.theagilemonkeys.llmental.embeddingsModel.EmbeddingsModel

const val EMBEDDING_MODEL_ID = "text-embedding-ada-002"

context(OpenAI)
class OpenAIEmbeddingsModel : EmbeddingsModel<Any> {

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
