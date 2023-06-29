package com.theagilemonkeys.llmental.semanticsearch.handlers

import com.theagilemonkeys.llmental.core.handler.handler
import com.theagilemonkeys.llmental.semanticsearch.schema.Id

data class SearchRequest(val query: String, val clusterIds: List<Id>? = null, val limit: Int? = null)

/**
 * TODO: How do we handle handler environment variables?
 */
private const val threshold = 0.5f

val search = handler("search") { request: SearchRequest ->
    val queryEmbedding = embed(listOf(request.query)).first()
    matchEmbed(
        MatchEmbedRequest(queryEmbedding, request.clusterIds, threshold, request.limit)
    )
}