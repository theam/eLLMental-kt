package com.theagilemonkeys.llmental.embeddingsModel

import com.theagilemonkeys.llmental.core.schema.Embedding

interface EmbeddingsModel<Params> {
    suspend fun embed(text: String, params: Params? = null): Embedding
}