package com.theagilemonkeys.llmental.vectorStore

import com.theagilemonkeys.llmental.core.Abstrakt
import com.theagilemonkeys.llmental.core.schema.SemanticEntry

interface VectorStore {
    context(Abstrakt)
    suspend fun store(semanticEntry: SemanticEntry)

    context(Abstrakt)
    suspend fun search(semanticEntry: SemanticEntry): List<SemanticEntry>
}