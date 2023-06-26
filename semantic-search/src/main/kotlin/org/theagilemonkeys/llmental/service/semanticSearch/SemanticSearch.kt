package org.theagilemonkeys.llmental.service.semanticSearch

class SemanticSearch {
    fun learn(entry: SemanticEntry): Boolean {
        throw NotImplementedError()
    }

    fun search(text: String): List<SemanticEntry> {
        throw NotImplementedError()
    }
}