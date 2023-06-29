package com.theagilemonkeys.llmental.semanticsearch.schema

data class SemanticEntry(
    val text: String,
    val metadata: Map<String, Any>? = null,
    val clusterId: Id? = null
)

