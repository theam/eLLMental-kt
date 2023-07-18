package com.theagilemonkeys.ellmental.core.schema

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
/**
 * Vector Embeddings
 *
 * An Embedding is a list of doubles that represents a vector in a multidimensional space.
 * It is useful to represent the semantic meaning of a word or a sentence.
 *
 * This class is inlined to avoid the overhead of creating a new object for each embedding.
 *
 * @param value the list of doubles that represents the vector
 * @see <a href="https://en.wikipedia.org/wiki/Word_embedding">Word Embedding</a>
 */
value class Embedding(val value: List<Double>)
