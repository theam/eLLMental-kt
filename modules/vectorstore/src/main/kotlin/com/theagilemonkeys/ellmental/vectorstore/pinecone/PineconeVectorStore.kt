package com.theagilemonkeys.ellmental.vectorstore.pinecone

import com.theagilemonkeys.ellmental.core.api.toSerializer
import com.theagilemonkeys.ellmental.core.schema.Embedding
import com.theagilemonkeys.ellmental.core.schema.Id
import com.theagilemonkeys.ellmental.core.schema.SemanticEntry
import com.theagilemonkeys.ellmental.vectorstore.QueryOutput
import com.theagilemonkeys.ellmental.vectorstore.VectorStore
import com.theagilemonkeys.ellmental.vectorstore.pinecone.Schema.Vectors
import kotlinx.serialization.json.Json
import org.http4k.client.OkHttp
import org.http4k.core.HttpHandler
import org.http4k.core.Method
import org.http4k.core.Request

/**
 * # Pinecone Vector Store
 *
 * Implementation of the [VectorStore] interface that uses the Pinecone API.
 *
 * @param apiKey The API key to use to authenticate with the Pinecone API.
 * @param url The URL of the Pinecone API.
 */
class PineconeVectorStore(
    private val apiKey: String,
    private val url: String,
    private val client: HttpHandler = OkHttp(),
) : VectorStore {

    private fun post(path: String, bodyString: String? = null): String {
        val request = Request(Method.POST, "$url$path")
            .header("accept", "application/json")
            .header("content-type", "application/json")
            .header("Api-Key", apiKey)
            .body(bodyString ?: "")

        val response = client(request)
        check(response.status.successful) {
            "Error on request to $path: ${response.status.code} ${response.bodyString()}"
        }
        return response.bodyString()
    }

    /**
     * Upserts a semantic entry into the store.
     *
     * @param semanticEntry The semantic entry to upsert.
     */
    override suspend fun upsert(semanticEntry: SemanticEntry) {
        val body = Schema.UpsertBody(
            Vectors(
                id = semanticEntry.id.value,
                values = semanticEntry.embedding.value,
                sparseValues = null,
                metadata = semanticEntry.metadata
            ),
        )
        val bodyString = Json.encodeToString(Schema.UpsertBody.serializer(), body)
        post("/vectors/upsert", bodyString)
    }

    /**
     * Queries the store for semantic entries. Uses a `topK` value of 10.
     *
     * @param semanticEntry The semantic entry to query for.
     * @return a [QueryOutput] that contains a list of semantic entries that match the query.
     */
    override suspend fun query(semanticEntry: SemanticEntry): QueryOutput {
        val body = Schema.QueryBody(
            topK = 10,
            includeValues = true,
            includeMetadata = true,
            vector = semanticEntry.embedding.value,
        )
        val bodyString = Json.encodeToString(Schema.QueryBody.serializer(), body)
        val responseString = post("/query", bodyString)
        val response =
            Json.decodeFromString(Schema.QueryResponse::class.toSerializer(), responseString)
        val entries = response.matches.map {
            SemanticEntry(
                id = Id(it.id),
                embedding = Embedding(it.values ?: emptyList()),
                metadata = it.metadata ?: emptyMap(),
            )
        }
        return QueryOutput(entries)
    }
}
