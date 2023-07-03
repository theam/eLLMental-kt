package com.theagilemonkeys.llmental.semanticsearch

import com.theagilemonkeys.llmental.core.Abstrakt
import com.theagilemonkeys.llmental.core.schema.SemanticEntry
import com.theagilemonkeys.llmental.embeddingsModel.EmbeddingsModel
import com.theagilemonkeys.llmental.vectorStore.VectorStore

class SemanticSearch {

    context(Abstrakt, EmbeddingsModel, VectorStore)
    suspend fun learn(text: String) {
        val embedding = embed(text)
        val semanticEntry = SemanticEntry(text, embedding = embedding)
        this@VectorStore.store(semanticEntry)
    }

    context(Abstrakt, EmbeddingsModel, VectorStore)
    suspend fun search(text: String): List<SemanticEntry> {
        val embedding = embed(text)
        val semanticEntry = SemanticEntry(text, embedding = embedding)
        return this@VectorStore.search(semanticEntry)
    }
}
