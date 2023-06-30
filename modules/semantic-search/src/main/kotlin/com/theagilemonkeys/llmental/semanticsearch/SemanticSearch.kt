package com.theagilemonkeys.llmental.semanticsearch

import com.theagilemonkeys.llmental.core.Mandatory
import com.theagilemonkeys.llmental.core.PrimitiveModule
import com.theagilemonkeys.llmental.core.handler.handler
import com.theagilemonkeys.llmental.core.makeDsl
import com.theagilemonkeys.llmental.core.schema.SemanticEntry
import com.theagilemonkeys.llmental.embeddingsModel.EmbeddingsModel
import com.theagilemonkeys.llmental.vectorStore.VectorStore

data class SemanticSearch(
    @Mandatory val name: String,
    @Mandatory var embeddingsModel: EmbeddingsModel,
    @Mandatory var vectorStore: VectorStore
) : PrimitiveModule() {
    var learn = handler("learn") { text: String ->
        val embedding = embeddingsModel.embed(text)
        val semanticEntry = SemanticEntry(text, embedding = embedding)
        vectorStore.store(semanticEntry)
        semanticEntry
    }

    var search = handler("learn") { text: String ->
        val embedding = embeddingsModel.embed(text)
        val semanticEntry = SemanticEntry(text, embedding = embedding)
        vectorStore.search(semanticEntry)
    }
}

fun semanticSearch(name: String, embeddingsModel: EmbeddingsModel, vectorStore: VectorStore): SemanticSearch =
    makeDsl(SemanticSearch(name, embeddingsModel, vectorStore)) {}