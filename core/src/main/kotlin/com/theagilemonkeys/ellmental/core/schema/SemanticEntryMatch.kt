package com.theagilemonkeys.ellmental.core.schema

import kotlinx.serialization.Serializable

@Serializable
data class SemanticEntryMatch(
    val id: Id,
    val score: Double,
    val content: String,
    val metadata: Map<String, String>? = null,
    val clusterId: Id? = null
)