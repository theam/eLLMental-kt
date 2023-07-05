package com.theagilemonkeys.llmental.embeddingsModel.openai

import com.theagilemonkeys.llmental.core.schema.Embedding
import com.theagilemonkeys.llmental.embeddingsModel.EmbeddingsModel

class OpenAIEmbeddingsModel(
    private val apiKey: String
) : EmbeddingsModel<Nothing> {

    override suspend fun embed(text: String, params: Nothing?): Embedding {
        // TODO: Initialize and call the actual OpenAI API
        return Embedding(
            arrayOf(
                text.length.toDouble(),
                0.0,
                0.0,
                0.0,
                0.0
            )
        )
    }
}
