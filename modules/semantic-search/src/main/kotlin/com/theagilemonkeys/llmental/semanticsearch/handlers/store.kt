package com.theagilemonkeys.llmental.semanticsearch.handlers

import com.theagilemonkeys.llmental.core.handler.handler
import com.theagilemonkeys.llmental.core.schema.Id

data class StoreRequest(
    val embedding: List<Float>,
    val metadata: Map<String, Any>? = null,
    val clusterId: Id? = null
)

val store = handler("store") { entries: List<StoreRequest> ->
    /**
     * TODO: Implement store handler specific implementations.
     * It should return a list of ids of the stored items.
     */
    listOf<Id>()
}