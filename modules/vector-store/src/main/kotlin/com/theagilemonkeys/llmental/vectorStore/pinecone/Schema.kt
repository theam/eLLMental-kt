package com.theagilemonkeys.llmental.vectorStore.pinecone

import kotlinx.serialization.Serializable

class Schema {
    @Serializable
    data class SparseValues(
        val indices: List<Int>,
        val values: List<Double>
    )

    @Serializable
    data class Vectors(
        val id: String,
        val values: List<Double>,
        val sparseValues: SparseValues? = null,
        val metadata: Map<String, String>? = null
    )

    @Serializable
    data class UpsertBody(
        val vectors: Vectors,
        val namespace: String? = null
    )

    @Serializable
    data class QueryBody(
        val topK: Int,
        val namespace: String? = null,
        val filter: String? = null,
        val includeValues: Boolean? = null,
        val includeMetadata: Boolean? = null,
        val vector: List<Double>? = null,
        val id: String? = null
    )

    @Serializable
    data class QueryResponse(
        val matches: List<Match>,
        val namespace: String? = null,
        // This field is not documented in the Pinecone Docs
        // but it comes in the response, making the serializer
        // fail if it's not declared here.
        val results: List<String>? = null
    )

    @Serializable
    data class Match(
        val id: String,
        val score: Double,
        val values: List<Double>? = null,
        val sparseValues: SparseValues? = null,
        val metadata: Map<String, String>? = null
    )
}

