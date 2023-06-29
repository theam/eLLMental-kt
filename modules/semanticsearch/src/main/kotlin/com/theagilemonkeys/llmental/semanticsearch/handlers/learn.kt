package com.theagilemonkeys.llmental.semanticsearch.handlers

import com.theagilemonkeys.llmental.core.handler.handler
import com.theagilemonkeys.llmental.semanticsearch.schema.SemanticEntry

data class LearnRequest(val items: List<SemanticEntry>)

val learn = handler("learn") { request: LearnRequest ->
    val embeddings = embed(request.items.map { it.text })
    store(embeddings.zip(request.items).map { pair ->
        StoreRequest(
            pair.first,
            pair.second.metadata,
            pair.second.clusterId
        )
    })
}

