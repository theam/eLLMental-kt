package com.theagilemonkeys.ellmental.core.schema

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class SemanticEntry(
    val id: Id = generateId(),
    val embedding: Embedding,
    val metadata: Map<String, String>? = null,
    val clusterId: Id? = null
) {
    companion object {
        fun generateId() = Id(UUID.randomUUID().toString())
    }
}

