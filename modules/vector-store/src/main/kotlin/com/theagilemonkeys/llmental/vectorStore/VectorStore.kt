package com.theagilemonkeys.llmental.vectorStore

import com.theagilemonkeys.llmental.core.schema.SemanticEntry

interface VectorStore {
    suspend fun store(semanticEntry: SemanticEntry)

    suspend fun search(semanticEntry: SemanticEntry): List<SemanticEntry>
}