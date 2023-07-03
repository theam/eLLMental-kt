package com.theagilemonkeys.llmental.embeddingsModel

import com.theagilemonkeys.llmental.core.Abstrakt
import com.theagilemonkeys.llmental.core.schema.Embedding

interface EmbeddingsModel {
    context(Abstrakt)
    suspend fun embed(text: String): Embedding
}