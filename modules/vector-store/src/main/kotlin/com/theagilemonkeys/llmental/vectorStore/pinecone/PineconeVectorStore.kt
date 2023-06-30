package com.theagilemonkeys.llmental.vectorStore.pinecone

import com.theagilemonkeys.llmental.core.handler.handler
import com.theagilemonkeys.llmental.core.schema.SemanticEntry
import com.theagilemonkeys.llmental.vectorStore.VectorStore

/**
 * Creates a [VectorStore] that uses Pinecone as the underlying storage.
 *
 * @param apiKey The API key to use for Pinecone.
 * @param indexName The name of the index to use for Pinecone.
 */
fun pineconeVectorStore(
    apiKey: String,
    indexName: String
): VectorStore {
    return VectorStore(
        "pinecone",
        handler("store") { entry: SemanticEntry ->
            // TODO: Implement Pinecone store
            {}
        },
        handler("search") { entry: SemanticEntry ->
            // TODO: Implement Pinecone search
            listOf(entry)
        }
    )
}