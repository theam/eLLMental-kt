package com.theagilemonkeys.llmental.vectorStore

import com.theagilemonkeys.llmental.core.Mandatory
import com.theagilemonkeys.llmental.core.PrimitiveModule
import com.theagilemonkeys.llmental.core.handler.Handler
import com.theagilemonkeys.llmental.core.schema.SemanticEntry

typealias StoreHandler = Handler<SemanticEntry, Unit>
typealias SearchHandler = Handler<SemanticEntry, List<SemanticEntry>>

data class VectorStore(
    @Mandatory val name: String,
    @Mandatory var store: StoreHandler,
    @Mandatory var search: SearchHandler
) : PrimitiveModule() {}
