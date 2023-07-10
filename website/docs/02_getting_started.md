# Getting started

The main package eLLMental offers is called `ellmental-core`. In this package, we provide an API implementation for your
AI applications. This API currently supports two kinds of operations: write, and read. These two kinds of operations
can be easily mapped to any kind of API protocol. By default, we offer a REST-style HTTP mapping, but you can easily
map it to GraphQL or gRPC.

> `ellmental-core` is built using Kotlin with JVM 17 and using gradle as our package manager.


## Modules

The eLLMental project also implements three different AI modules:

1. **A vector store:** Database or repository used to house and handle vector representations of words or phrases, known
   as embeddings. eLLMental implements different databases that support vector columns, like Pinecone or Supabase.
2. **Embedding generator:** The service that is responsible for converting raw text data into representative numerical
   vectors, also known as embeddings.
3. **Semantic search module:** To search similarities in the vector store.
   Using [cosine similarity](https://en.wikipedia.org/wiki/Cosine_similarity), which measures the cosine of the angle
   between two vectors. The vectors that are close to each other (having a smaller angle between them)
   indicate more similar content.

> An example of how these modules are used can be found in the `semantic-search-service-demo` project.

## Creating a semantic index

In the case that you want to create your own semantic index, we recommend you to follow the guidelines below. Anyways
you can always see an example app in the [semantic search demo](https://github.com/theam/eLLMental/tree/main/semantic-search-service-demo) from
the repo.

First, you'll need to implement the `API.kt` module from `ellmental-core`. This includes two main operations: `read` and `write`.

Second, you'll have to select the embedding's model you want to use. If you want to use the implementations we provide, you
can use the ones in the `embeddings-model` module.

Third, you'll need your implementation to call the Vector store you'd want to use. Existing vector stores implementation are present in
the `vector-store` module.

Finally, you'll need to put everything together in the Semantic Search module. Here's an example with also the `Main.kt` file:

```kotlin
// Semantic search module
fun default(): SemanticSearch =
            with(OpenAIEmbeddingsModel("API KEY")) {
                with(PineconeVectorStore()) {
                    with(SemanticSearch()) {
                        this
                    }
                }
            }

```

```Main.kt
SemanticSearch.default().api.runHttp(port = 8080)
```

After that, you can run `./gradlew :<your_service>:run` to serve your API.

## Creating your own module

If you plan to create a different package or module using Kotlin (like `llmental-core`), you can duplicate the `.kotlin-template`
folder and rename it to your package name. After that, you'll have to add the package name to the `settings.gradle.kts`
file, in the `includes` list. This way we will keep the same structure for all of them.
