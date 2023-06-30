package com.theagilemonkeys.llmental.embeddingsModel.openai

import com.theagilemonkeys.llmental.core.handler.handler
import com.theagilemonkeys.llmental.embeddingsModel.EmbeddingsModel

/**
 * OpenAI embeddings handler builder.
 * It uses the OpenAI `/embed` endpoint to get an embedding vector for a given text.
 */
fun openAIEmbeddingsModel(apiKey: String): EmbeddingsModel {
    return EmbeddingsModel("openAI", handler("embed")
    { text: String ->
        // TODO: Initialize and call the actual OpenAI API
        arrayOf(
            0.0,
            0.0,
            0.0,
            0.0,
            0.0
        )
    })
}