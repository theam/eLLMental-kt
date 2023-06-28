package com.theagilemonkeys.llmental.semanticsearch

data class SemanticEntry(
    val text: String,
    val metadata: Map<String, Any>? = null
)

