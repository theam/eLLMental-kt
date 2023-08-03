package com.theagilemonkeys.ellmental.vectorstore.chroma

import com.google.gson.Gson
import com.theagilemonkeys.ellmental.core.schema.Id
import com.theagilemonkeys.ellmental.core.schema.SemanticEntry
import com.theagilemonkeys.ellmental.core.schema.SemanticEntryMatch
import com.theagilemonkeys.ellmental.vectorstore.QueryOutput
import com.theagilemonkeys.ellmental.vectorstore.VectorStore
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import tech.amikos.chromadb.Client
import tech.amikos.chromadb.Collection
import tech.amikos.chromadb.handler.ApiClient
import tech.amikos.chromadb.handler.DefaultApi
import tech.amikos.chromadb.model.QueryEmbedding
import tech.amikos.chromadb.model.QueryEmbedding.IncludeEnum
import java.util.stream.Collectors


/**
 * # Chroma Vector Store
 *
 * Implementation of the [VectorStore] interface that uses the Chroma API.
 *
 * @param apiKey The API key to use to authenticate with the Chroma API.
 * @param url The URL of the Chroma API.
 */
class ChromaVectorStore @JvmOverloads constructor(
    private val collectionName: String,
    private val url: String,
) : VectorStore {
    private val collection = run {
        val client = Client(url)
        client.createCollection(collectionName, mapOf(Pair("hnsw:space", "ip")), true, null)
    }

    // TODO: Workaround to make use of Chroma client library without using an embedding function. We need to create a new client library.
    private val api: DefaultApi = run {
        val client = ApiClient()
        client.setBasePath(url)
        DefaultApi(client)
    }

    /**
     * Upserts a semantic entry into the store.
     *
     * @param semanticEntry The semantic entry to upsert.
     */
    override suspend fun upsert(semanticEntry: SemanticEntry) {
        var metadata = semanticEntry.metadata ?: emptyMap()
        metadata = metadata + mapOf("content" to semanticEntry.content)
        semanticEntry.clusterId?.value?.let {
            metadata = metadata + mapOf("clusterId" to it)
        }
        val newMetadata = mapOf("metadata" to Json.encodeToString(metadata))

        collection.upsert(
            // TODO: This shouldn't be a conversion. Embeddings are float values, not doubles.
            listOf(semanticEntry.embedding.value.map { it.toFloat() }),
            listOf(newMetadata),
            null,
            listOf(semanticEntry.id.value),
        )
    }

    /**
     * Queries the store for semantic entries. Uses a `topK` value of 10.
     *
     * @param semanticEntry The semantic entry to query for.
     * @return a [QueryOutput] that contains a list of semantic entries that match the query.
     */
    // TODO: This is not supporting cluster IDs filtering. Implementation missing.
    override suspend fun query(semanticEntry: SemanticEntry, itemsLimit: Int): QueryOutput {
        val result = collection.query(
            listOf(semanticEntry.embedding.value.map { it.toFloat() }),
            itemsLimit,
            null,
            null,
            listOf(IncludeEnum.DISTANCES, IncludeEnum.METADATAS)
        )

        val entries = result?.let {
            result.metadatas.flatten().zip(result.ids.flatten())
                .zip(result.distances.flatten()) { (metadata, id), score ->
                    val metadataMap: Map<String, String>? = metadata["metadata"]?.let {
                        if (it is String) Json.decodeFromString(it) else null
                    }

                    val clusterId = metadataMap?.get("clusterId")?.let { Id(it) }
                    val content = metadataMap?.get("content").orEmpty()
                    SemanticEntryMatch(
                        id = Id(id),
                        metadata = metadataMap?.let { it - "content" - "clusterId" },
                        content = content,
                        clusterId = clusterId,
                        score = score.toDouble()
                    )
            }
        } ?: emptyList()
        return QueryOutput(entries)
    }


    // TODO: Workaround to make use of Chroma client library without using an embedding function. We need to create a new client library.
    private fun Collection.query(
        embeddings: List<List<Float>>?,
        nResults: Int?,
        where: Map<String?, String?>?,
        whereDocument: Map<String?, String?>?,
        include: List<IncludeEnum?>?
    ): Collection.QueryResponse? {
        val body = QueryEmbedding()
        body.queryEmbeddings(embeddings)
        body.nResults(nResults)
        body.include(include)
        if (where != null) {
            body.where(
                where.entries.stream().collect(
                    Collectors.toMap<Map.Entry<String?, String?>, String, Any?>(
                        { (key, _) -> key },
                        { (_, value): Map.Entry<String?, String?> -> value })
                )
            )
        }
        if (whereDocument != null) {
            body.whereDocument(
                whereDocument.entries.stream().collect(
                    Collectors.toMap<Map.Entry<String?, String?>, String, Any?>(
                        { (key, _) -> key },
                        { (_, value): Map.Entry<String?, String?> -> value })
                )
            )
        }
        val gson = Gson()
        val json = gson.toJson(api.getNearestNeighbors(body, collection.id))
        return Gson().fromJson(json, Collection.QueryResponse::class.java)
    }
}
