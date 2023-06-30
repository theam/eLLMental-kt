package com.theagilemonkeys.llmental.changeme

import com.theagilemonkeys.llmental.core.api.api
import com.theagilemonkeys.llmental.core.api.toHttpApp
import com.theagilemonkeys.llmental.embeddingsModel.openai.openAIEmbeddingsModel
import com.theagilemonkeys.llmental.semanticsearch.semanticSearch
import com.theagilemonkeys.llmental.vectorStore.pinecone.pineconeVectorStore

/**
 * This is a demo of the Semantic Search Service using:
 *   * OpenAI's embeddings model
 *   * Pinecone as vector store
 *
 * It will start a server on port 8080 with the following endpoints:
 * - POST /learn
 * - POST /search
 */
fun main() {
    api("SemanticSearchService") {
        with(
            semanticSearch(
                "semanticSearch",
                openAIEmbeddingsModel("someAPIKey"),
                pineconeVectorStore("someOtherAPIKey", "someVectorStoreName")
            )
        ) {
            write(learn)
            read(search)
        }
    }
        .toHttpApp()
        .start()
        .block()
}
