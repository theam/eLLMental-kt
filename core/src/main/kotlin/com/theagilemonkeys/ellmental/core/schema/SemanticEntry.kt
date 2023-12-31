package com.theagilemonkeys.ellmental.core.schema

import java.util.*
import kotlinx.serialization.Serializable

/**
 * # Semantic Entry
 *
 * A Semantic Entry is a representation of a semantic concept, useful to perform semantic searches,
 * and interacting with a vector embedding database.
 *
 * @param id the id of the entry - if not provided, a random id will be generated
 * @param embedding the vector embedding of the entry
 * @param metadata a map of metadata associated with the entry - optional
 * @param clusterId the id of the cluster that the entry belongs to - optional
 */
@Serializable
data class SemanticEntry(
    val id: Id = generateId(),
    val content: String,
    val embedding: Embedding,
    val metadata: Map<String, String>? = null,
    val clusterId: Id? = null
) {
  companion object {
    fun generateId() = Id(UUID.randomUUID().toString())
  }
}
