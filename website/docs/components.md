---
title: Components
---

# Components Overview

Welcome to the Components Overview section of the eLLMental library! eLLMental is like a master chef's kitchen, but
instead of preparing food, it helps you whip up AI applications with ease through

Our kitchen is quite unique. We use a Kotlin technique called "generic receivers". This is like borrowing recipes from
different cookbooks to make our own unique dishes. It's a common practice in eLLMental, making everything well-organized
and easy to use.

Let's take a peek at one of our recipes:

```kotlin
import com.theagilemonkeys.ellmental.embeddingsmodel.*

suspend fun <Ctx> Ctx.myRecipe()
        where Ctx : EmbeddingsModel<Any> {
    val embedding = embed("This is a text")
    println(embedding.vector)
}
```

In the `myRecipe` function, we're telling Kotlin that we'd like to borrow the `embed` function from
the `EmbeddingsModel`
cookbook. This
way, we can use `embed("This is a text")` right in our function as if it's always been part of our recipe collection.

Using these borrowed recipes is what makes creating AI applications with eLLMental so smooth and straightforward.

If you want to learn more about this Kotlin feature,
check out [this StackOverflow answer](https://stackoverflow.com/questions/45875491/what-is-a-receiver-in-kotlin).

## Embeddings Model

Imagine the Embeddings Model as your very own language translator. This tool in eLLMental takes regular text and
transforms it into a special format called 'embedding'. The `embed` function is like our magic spell that does this
transformation.

Here's a simple way to understand it. You tell `embed` your text, like "This is a text", and it returns an Embedding -
kind of like a secret code for your text.

If you want to use this magic spell in your own function or class, you can! Here's how:

```kotlin
import com.theagilemonkeys.ellmental.embeddingsmodel.*

suspend fun <Ctx> Ctx.myFunction()
        where Ctx : EmbeddingsModel<Any> {
    val embedding = embed("This is a text")
    println(embedding.vector)
}
```

In `myFunction`, we're asking Kotlin to let us use the `embed` function from our Embeddings Model translator. So we can
cast our spell - `embed("This is a text")` - right in our function as if it's always been there.

## Vector Store

Think of the Vector Store as your pantry for all the Embeddings you've cooked up. It's a special storage where you can
keep and fetch your Embeddings, ready to serve in your AI feast.

Here's a yummy way to look at it. Imagine you've baked a pie called "This is a text". You can store this pie in your
pantry and grab it whenever you're ready to serve it.

Fancy using the Vector Store in your own kitchen? Here's how you can:

```kotlin
import com.theagilemonkeys.ellmental.vectorstore.*

suspend fun <Ctx> Ctx.myFunction()
        where Ctx : VectorStore,
              Ctx : EmbeddingsModel<Any> {
    val embedding = embed("This is a text")              // Here we use the Embeddings Model to bake our pie
    store(embedding)                                     // Here we store our pie in the Vector Store
    val retrievedEmbedding = retrieve("This is a text")  // And now we fetch our pie!
    println(retrievedEmbedding.vector)
}
```

In `myFunction`, we first bake our pie using the `embed` function from the Embeddings Model. Then we store our pie
using `store(embedding)`. When we're ready, we can fetch our pie with `retrieve("This is a text")`.

## Semantic Search

The Semantic Search is like your very own search engine. It's a tool that helps you find the most similar Embeddings to
your search query.

Here's a simple way to understand it. Imagine you're looking for a recipe for a pie. You can use the Semantic Search to
find the most similar Embeddings to your search query, like "This is a text". Then you can use the Vector Store to
retrieve the Embeddings for these similar pies.

If you want to use the Semantic Search in your own function or class, you can! Here's how:

```kotlin
import com.theagilemonkeys.ellmental.semanticsearch.*

suspend fun <Ctx> Ctx.myFunction()
        where Ctx : SemanticSearch {
    learn("This is a text")
    val similarTexts = search("This is a text")
}
```