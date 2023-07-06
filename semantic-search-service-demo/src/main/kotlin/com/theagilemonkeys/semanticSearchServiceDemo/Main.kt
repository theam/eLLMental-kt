package com.theagilemonkeys.semanticSearchServiceDemo

import com.theagilemonkeys.llmental.core.api.runHttp
import com.theagilemonkeys.llmental.semanticsearch.SemanticSearch
import kotlinx.coroutines.runBlocking


/**
 * This is a demo of the Semantic Search Service using:
 *   * OpenAI's embeddings model
 *   * Pinecone as vector store
 *
 * It will start a server on port 8080 with the following endpoints:
 * - POST /learn
 * - POST /search
 */
fun main(): Unit = runBlocking {
    SemanticSearch.default().api.runHttp(port = 8080)
}
