package com.theagilemonkeys.llmental.embeddingsModel.openai

import com.theagilemonkeys.llmental.core.Abstrakt
import com.theagilemonkeys.llmental.core.schema.Embedding
import com.theagilemonkeys.llmental.embeddingsModel.EmbeddingsModel

class OpenAIEmbeddingsModel(apiKey: String) : EmbeddingsModel {

    context(Abstrakt)
    override suspend fun embed(text: String): Embedding {
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
