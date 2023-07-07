# ![eLLMental](website/static/img/eLLMental logo with frame.png)

---

# Introduction

The eLLMental project raises from the necessity of developer's to have a single framework that joins flexibility,
efficiency and productivity while building the different block an AI application. During this time, we've seen different
challenges that motivated us to start building this project:

1. **Lack of Robust Tools and Libraries:** The field being fairly new means there's a lack of effective tools
   custom-made for LLMs, making it more difficult for developers to understand how LLMs work nowadays.
2. **MLOps management:** There's no one-size-fits-all solution in MLOps and particularly with LLMs, resulting in
   heterogeneity in the tools, platforms, and workflow processes. This means more time is needed to find the right
   stack. Also, evaluating LLMs performance is not straightforward.
3. **Security**: Ensuring the security of the underlying infrastructure, including network security, firewall
   configurations, and container security, is a major challenge. Setting up appropriate monitoring and alerts can be
   both technically challenging and resource-intensive.
4. **Privacy:** LLMs often require large amounts of data, raising potential data privacy issues, which may not be
   adequately addressed by existing MLOps platforms.
5. **Flexibility:** Application's needs grow constantly, and so does AI applications. That's why we are adopting a
   flexible philosophy, by building separate software blocks that con compose themselves into bigger customizable AI
   applications.

Overall, eLLMental is designed to help software engineers build AI-driven applications in an efficient manner by 
removing all common headaches while integrating AI in your development environment.


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

# Contributing

We're happy to see that you're interested in contributing, that's great! In the sections below, you can see how to report 
bugs or suggest enhancements.

If your plan is to create a different package or module using Kotlin (like `llmental-core`), you can duplicate the `.kotlin-template`
folder and rename it to your package name. After that, you'll have to add the package name to the `settings.gradle.kts`
file, in the `includes` list. This way we will keep the same structure for all of them.

## Reporting bugs

Before creating a bug report, please search for similar issues to make sure that they're not already reported. If you
don't find any, go ahead and create an issue including as many details as possible.

> If you find a Closed issue that seems related to the issues that you're experiencing, make sure to reference it in the 
> body of your new one by writing its number like this => #42 (Github will autolink it for you).

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

> Remember to label the issue wit an "enhancement" tag

# License

This eLLMental project is licensed under the Business source license. You can take a look at the details
in [this article](https://timreview.ca/article/691).

eLLMental is a project by [The Agile Monkeys](https://www.theagilemonkeys.com/).
