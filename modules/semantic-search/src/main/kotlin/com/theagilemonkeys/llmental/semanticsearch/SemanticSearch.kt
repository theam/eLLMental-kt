package com.theagilemonkeys.llmental.semanticsearch

import com.aallam.openai.client.OpenAI
import com.theagilemonkeys.llmental.core.api.apiDefinition
import com.theagilemonkeys.llmental.core.schema.SemanticEntry
import com.theagilemonkeys.llmental.embeddingsModel.EmbeddingsModel
import com.theagilemonkeys.llmental.embeddingsModel.openai.OpenAIEmbeddingsModel
import com.theagilemonkeys.llmental.vectorStore.VectorStore
import com.theagilemonkeys.llmental.vectorStore.pinecone.PineconeVectorStore

context(EmbeddingsModel<Any>, VectorStore)
class SemanticSearch {
    suspend fun learn(text: String) {
        val embedding = embed(text)
        val semanticEntry = SemanticEntry(text, embedding = embedding)
        upsert(semanticEntry)
    }

    suspend fun search(text: String): List<SemanticEntry> {
        val embedding = embed(text)
        val semanticEntry = SemanticEntry(text, embedding = embedding)
        return query(semanticEntry)
    }

    /**
     * The default API definition for the Semantic Search Service.
     */
    val api = SemanticSearch::class.apiDefinition {
        write("learn") { s: String -> learn(s) }
        read("search") { s: String -> search(s) }
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
        @Suppress("NestedBlockDepth")
        fun default() =
            with(OpenAI(token = "APIKEY")) {
                with(OpenAIEmbeddingsModel()) {
                    with(PineconeVectorStore()) {
                        with(SemanticSearch()) {
                            this
                        }
                    }
                }
            }

    }
}

