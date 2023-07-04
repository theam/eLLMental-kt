package com.theagilemonkeys.llmental.semanticsearch

import com.theagilemonkeys.llmental.core.api.Read
import com.theagilemonkeys.llmental.core.api.Write
import com.theagilemonkeys.llmental.core.api.apiDefinition
import com.theagilemonkeys.llmental.core.schema.SemanticEntry
import com.theagilemonkeys.llmental.embeddingsModel.EmbeddingsModel
import com.theagilemonkeys.llmental.embeddingsModel.openai.OpenAIEmbeddingsModel
import com.theagilemonkeys.llmental.vectorStore.VectorStore
import com.theagilemonkeys.llmental.vectorStore.pinecone.PineconeVectorStore

context(EmbeddingsModel<Nothing>, VectorStore)
class SemanticSearch {
    suspend fun learn(text: String) {
        val embedding = embed(text)
        val semanticEntry = SemanticEntry(text, embedding = embedding)
        this@VectorStore.store(semanticEntry)
    }

    suspend fun search(text: String): List<SemanticEntry> {
        val embedding = embed(text)
        val semanticEntry = SemanticEntry(text, embedding = embedding)
        return this@VectorStore.search(semanticEntry)
    }

    /**
     * The default API definition for the Semantic Search Service.
     */
    val api = SemanticSearch::class.apiDefinition {
        define("learn") like Write
        define("search") like Read
    }


    /**
     * Default, hassle-free, implementation of the Semantic Search Service.
     *
     * Uses:
     *  * OpenAI's embeddings model
     *  * Pinecone as vector store
     *  * HTTP as API
     *
     *  Usage:
     *
     *  SemanticSearch.default()
     */
    companion object {
        fun default(): SemanticSearch =
            with(OpenAIEmbeddingsModel("API KEY")) {
                with(PineconeVectorStore()) {
                    with(SemanticSearch()) {
                        this
                    }
                }
            }

    }
}

