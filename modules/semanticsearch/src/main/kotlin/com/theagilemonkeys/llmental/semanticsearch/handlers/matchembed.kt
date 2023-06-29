package com.theagilemonkeys.llmental.semanticsearch.handlers

import com.theagilemonkeys.llmental.core.handler.handler
import com.theagilemonkeys.llmental.semanticsearch.schema.Id
import com.theagilemonkeys.llmental.semanticsearch.schema.SemanticEntry

data class EmbedMatch(val entry: SemanticEntry, val score: Float)
data class MatchEmbedRequest(val embedding: List<Float>, val clusterIds: List<Id>? = null, val threshold: Float, val limit: Int? = null)

val matchEmbed = handler("matchEmbed") { request: MatchEmbedRequest ->
    /**
     * TODO: Abstract handler, we need an specific implementation
     */
    listOf<EmbedMatch>()
}