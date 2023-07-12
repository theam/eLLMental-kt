package com.theagilemonkeys.ellmental.embeddingsmodel

import com.theagilemonkeys.ellmental.core.schema.Embedding

interface EmbeddingsModel<Params> {
    suspend fun embed(text: String, params: Params? = null): Embedding
}
