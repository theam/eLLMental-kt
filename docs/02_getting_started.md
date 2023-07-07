# Getting started

The main package eLLMental offers is called `ellmental-core`. In this package, we provide an API implementation for your
AI applications. This API currently support two kind of operations: write (HTTP POST), and read (HTTP GET). You can provide
your own implementation for these two operations, as you can see in the `SemanticSearch.kt` file.

Technical-wise, `ellmental-core` is built under the following stack:

|                      |        |
|----------------------|--------|
| Package Manager      | Gradle |
| Programming Language | Kotlin |
| JVM Version          | 17     |


## Modules

The eLLMental project also implements three different AI modules:

1. **A vector store:** Database or repository used to house and handle vector representations of words or phrases, known
   as embeddings. eLLMental implements different databases that support vector columns, like Pinecone or Supabase.
2. **Embedding generator:** The service that is responsible for converting raw text data into representative numerical
   vectors, also known as embeddings.
3. **Semantic search module:** To search similarities in the vector store.
   Using [cosine similarity](https://en.wikipedia.org/wiki/Cosine_similarity), which measures the cosine of the angle
   between two vectors. The vectors close to each other (having a smaller angle between them)
   indicate more similar content.

> An example of how these modules are use can be found in the `semantic-search-service-demo` project.

These modules work on their own, but we can manage them in an easier way, by using the `YOLO` CLI tool, which will help
you set up these different modules.

The [YOLO](https://github.com/theam/yolo) tool is the way we configure our applications to import different AI
modules and components.