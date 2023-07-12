package com.theagilemonkeys.ellmental.vectorstore

import com.theagilemonkeys.ellmental.core.schema.SemanticEntry
import kotlinx.serialization.Serializable

@Serializable
data class QueryOutput(val entries: List<SemanticEntry>)

interface VectorStore {
    suspend fun upsert(semanticEntry: SemanticEntry)

    suspend fun query(semanticEntry: SemanticEntry): QueryOutput
}