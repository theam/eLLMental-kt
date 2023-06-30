package com.theagilemonkeys.llmental.embeddingsModel

import com.theagilemonkeys.llmental.core.Mandatory
import com.theagilemonkeys.llmental.core.PrimitiveModule
import com.theagilemonkeys.llmental.core.handler.Handler
import com.theagilemonkeys.llmental.core.schema.Embedding

typealias EmbedHandler = Handler<String, Embedding>

class EmbeddingsModel(
    @Mandatory val name: String,
    @Mandatory var embed: EmbedHandler
) : PrimitiveModule() {}
