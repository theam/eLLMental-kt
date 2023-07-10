# ![eLLMental](website/static/img/eLLMental logo with frame.png)

---

# Introduction

The eLLMental project raises from the necessity of developers to have a single framework that joins flexibility,
efficiency, and productivity while building the different blocks of an AI application. During this time, we've seen different
challenges that motivated us to start building this project:

1. **Lack of Robust Tools and Libraries:** The field being fairly new means there's a lack of effective tools
   custom-made for LLMs, making it more difficult for developers to understand how LLMs work nowadays.
2. **MLOps management:** There's no one-size-fits-all solution in MLOps and particularly with LLMs, resulting in
   heterogeneity in the tools, platforms, and workflow processes. This means more time is needed to find the right
   stack. Also, evaluating LLMs' performance is not straightforward.
3. **Security**: Ensuring the security of the underlying infrastructure, including network security, firewall
   configurations, and container security, is a major challenge. Setting up appropriate monitoring and alerts can be
   both technically challenging and resource-intensive.
4. **Privacy:** LLMs often require large amounts of data, raising potential data privacy issues, which may not be
   adequately addressed by existing MLOps platforms.
5. **Flexibility:** Regular applications need to grow constantly, and so do AI applications. That's why we are adopting a
   flexible philosophy, by building separate software blocks that con compose themselves into bigger customizable AI
   applications.

Overall, eLLMental is designed to help software engineers efficiently build AI-driven applications by
removing all common headaches while integrating AI into your development environment.


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

# Contributing

We're happy to see that you're interested in contributing, that's great! In the sections below, you can see how to report 
bugs or suggest enhancements.


## Reporting bugs

Before creating a bug report, please search for similar issues to make sure that they're not already reported. If you
don't find any, go ahead and create an issue including as many details as possible.

> If you find a Closed issue that seems related to the issues that you're experiencing, make sure to reference it in the 
> body of your new one by writing its number like this => #42 (Github will auto-link it for you).

Bugs are tracked as GitHub issues. Explain the problem and include additional details to help maintainers reproduce the
problem:

- Use a clear and descriptive title for the issue to identify the problem.
- Describe the exact steps which reproduce the problem in as many details as possible.
- Provide specific examples to demonstrate the steps. Include links to files or GitHub projects, or copy/pasteable
  snippets, which you use in those examples. If you're providing snippets in the issue, use Markdown code blocks.
- Describe the behavior you observed after following the steps and point out what exactly is the problem with that
  behavior.
- Explain which behavior you expected to see instead and why.
- If the problem is related to performance or memory, include a CPU profile capture with your report.

> Remember to label the issue with a "bug" tag

## Suggesting Enhancements

Enhancement suggestions are tracked as GitHub issues. Make sure you provide the following information:

- Use a clear and descriptive title for the issue to identify the suggestion.
- Provide a step-by-step description of the suggested enhancement in as many details as possible.
- Provide specific examples to demonstrate the steps. Include copy/pasteable snippets which you use in those examples,
  as Markdown code blocks.
- Describe the current behavior and explain which behavior you expected to see instead and why.
- Explain why this enhancement would be useful to most Booster users and isn't something that can or should be
  implemented as a community package.
- List some other libraries or frameworks where this enhancement exists.

> Remember to label the issue with an "enhancement" tag

# License

This eLLMental project is licensed under the Business source license. You can take a look at the details
in [this article](https://timreview.ca/article/691).

eLLMental is a project by [The Agile Monkeys](https://www.theagilemonkeys.com/).
