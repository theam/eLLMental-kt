package com.theagilemonkeys.llmental.vectorStore

import com.theagilemonkeys.llmental.core.schema.SemanticEntry
import kotlinx.serialization.Serializable

@Serializable
data class QueryOutput(val entries: List<SemanticEntry>)

interface VectorStore {
    suspend fun upsert(semanticEntry: SemanticEntry)

    suspend fun query(semanticEntry: SemanticEntry): QueryOutput
}