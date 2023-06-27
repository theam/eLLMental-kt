package org.theagilemonkeys.llmental.service

object SemanticSearch {
    fun learn(entry: SemanticEntry): Boolean {
        // TODO: Implement this
        return true
    }

    fun search(text: String): List<SemanticEntry> {
        // TODO: Implement this
        return listOf(SemanticEntry(text, mapOf("testKey" to "testValue")))
    }
}