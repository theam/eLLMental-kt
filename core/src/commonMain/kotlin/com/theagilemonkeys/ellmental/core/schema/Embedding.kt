package com.theagilemonkeys.ellmental.core.schema

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class Embedding(val value: List<Double>)
