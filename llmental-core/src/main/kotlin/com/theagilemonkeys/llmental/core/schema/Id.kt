package com.theagilemonkeys.llmental.core.schema

import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class Id(val value: String)