package com.theagilemonkeys.llmental.semanticsearch

import com.theagilemonkeys.llmental.core.api.api
import com.theagilemonkeys.llmental.semanticsearch.handlers.search
import com.theagilemonkeys.llmental.semanticsearch.learn.learn

val semanticSearchApi = api("SemanticSearch") {
    write(learn)
    read(search)
}

