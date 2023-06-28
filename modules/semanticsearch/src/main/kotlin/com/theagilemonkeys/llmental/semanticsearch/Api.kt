package com.theagilemonkeys.llmental.semanticsearch

import com.theagilemonkeys.llmental.core.api.api

val semanticSearchApi = api("SemanticSearch") {
    write(learn)
    read(search)
}

