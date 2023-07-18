package com.theagilemonkeys.ellmental.core.schema

import kotlinx.serialization.Serializable

/**
 * # Id
 *
 * An Id is a string that represents an identifier for a given object.
 *
 * This class is inlined to avoid the overhead of creating a new object for each Id.
 *
 * @param value the string that represents the identifier
 */
@Serializable
@JvmInline
value class Id(val value: String)
