package com.theagilemonkeys.ellmental.vectorstore

import com.theagilemonkeys.ellmental.core.schema.SemanticEntry
import com.theagilemonkeys.ellmental.core.schema.SemanticEntryMatch
import kotlinx.serialization.Serializable

/**
 * # Vector Store
 *
 * The Vector Store is a repository of semantic entries. It is used to store and query semantic entries.
 * It is useful together with the EmbeddingsModel module to store the embeddings of different texts.
 */
interface VectorStore {
    /**
     * Upserts a semantic entry into the store.
     *
     * @param semanticEntry The semantic entry to upsert.
     */
    suspend fun upsert(semanticEntry: SemanticEntry)

    /**
     * Queries the store for semantic entries.
     *
     * @param semanticEntry The semantic entry to query for.
     * @return a [QueryOutput] that contains a list of semantic entries that match the query.
     */
    suspend fun query(semanticEntry: SemanticEntry, itemsLimit: Int): QueryOutput
}

/**
 * The output of a query to the Vector Store.
 *
 * @property entries The list of semantic entries that match the query.
 */
@Serializable
data class QueryOutput(val entries: List<SemanticEntryMatch>)

