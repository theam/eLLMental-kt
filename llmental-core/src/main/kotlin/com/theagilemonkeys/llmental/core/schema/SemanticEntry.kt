package com.theagilemonkeys.llmental.core.schema

data class SemanticEntry(
    val text: String,
    val metadata: Map<String, String>? = null,
    val clusterId: Id? = null,
    val embedding: Embedding? = null
)

