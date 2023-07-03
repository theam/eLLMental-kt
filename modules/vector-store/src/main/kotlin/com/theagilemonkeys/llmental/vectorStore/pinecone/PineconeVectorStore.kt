package com.theagilemonkeys.llmental.vectorStore.pinecone

import com.theagilemonkeys.llmental.core.Abstrakt
import com.theagilemonkeys.llmental.core.schema.SemanticEntry
import com.theagilemonkeys.llmental.vectorStore.VectorStore

class PineconeVectorStore : VectorStore {
    context(Abstrakt)
    override suspend fun store(semanticEntry: SemanticEntry) {
        TODO()
    }

    context(Abstrakt)
    override suspend fun search(semanticEntry: SemanticEntry): List<SemanticEntry> {
        TODO()
    }
}