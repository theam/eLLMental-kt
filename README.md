# eLLMental

![eLLMental](website/static/img/logoellmental.png)

Welcome to eLLMental – your toolbox for the AI-era! This project is a treasure trove of configurable and composable components designed specifically to empower developers in the fascinating yet challenging journey of creating AI applications.

eLLMental erases the thin line between AI and conventional software development, giving you a direct pathway to seamlessly integrate AI components into your applications. With a wide array of tools and features ready for you to use, eLLMental offers an environment where AI becomes as accessible and manageable as any other part of your tech stack.

If you're ready for the challenge and excited about pushing the boundaries of what you can build with AI, step right into the world of eLLMental.

## Table of Contents

- [Why eLLMental?](#why-ellmental)
- [Quick Start Guide](#quick-start-guide)
- [Contributing and Community](#contributing-and-community)
- [License](#license)
- [Contact](#contact)

Indeed, that's a great angle to take. Let's emphasize the reasons why developers would find eLLMental beneficial for their work:

## Why eLLMental?

In the current landscape of AI application development, we recognized some recurrent challenges that developers face. We developed eLLMental as a direct response to these challenges. Here's why we believe eLLMental is your ideal set of tools for AI development:

1. **Simplicity in Complexity:** AI application development can be daunting. With eLLMental's configurable and composable components, the complexity inherent in AI development becomes significantly manageable. We aim to make the AI development process as simple and intuitive as developing any other software.

2. **Readiness for Production:** From development to deployment, all features of eLLMental are crafted with a production-ready mindset.

3. **Scalability and Flexibility:** eLLMental is designed to evolve with your needs. Whether you're building a small application or working on an enterprise-level project, eLLMental is designed to fit in your project.

4. **Continuous Improvement:** eLLMental continuously evolves for better. With the support of our active community and dedicated team, we regularly implement improvements and introduce innovative features to make eLLMental even more powerful and user-friendly.

5. **Making AI Accessible:** AI shouldn't be an exclusive club. By providing tools that simplifies AI development, we aim to make this powerful technology accessible to every developer out there, irrespective of their background in AI.

In a nutshell, eLLMental is our commitment to make AI development as simple, accessible, and effective as possible. We invite you to experience this commitment firsthand as you set sail into your next AI project with eLLMental.

## Quick Start Guide

eLLMental provides composable abstractions for common patterns used in AI applications. For instance, to build a semantic search service with a REST API, using the OpenAI embeddings model and Pinecone as the database, this is what you have to do:

1. Import the eLLMental dependencies in your `build.gradle.kts` file:

```kotlin
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.theam:ellmental:main'
}
```

2. Build the API injecting the chosen components as dependencies:

```kotlin
fun main(): Unit = runBlocking {
    with(OpenAI(token = "<OPENAI API KEY>")) {
        with(OpenAIEmbeddingsModel()) {
            with(PineconeVectorStore(apiKey = "<PINECONE API KEY>", url = "<PINECONE API URL>")) {
                with(SemanticSearch()) {
                    this.api.runHttp(port = 8080)
                }
            }
        }
    }
}
```

Refer to our [documentation site](https://docs.ellemental.com) to access more learning resources, a comprehensive list of the available components, and guides to use them for different purposes.

## Contributing and Community

We believe that community contributions are essential to the development and refinement of eLLMental. You can become a part of the eLLMental community in the following ways:

1. Join the conversation in our [Discord server](https://discord.gg/34cBbvjjAx).
2. Send us suggestions, questions, or feature requests by creating a [New Issue](https://github.com/theam/ellmental/issues/new).
3. Look at the [Open Issues](https://github.com/theam/ellmental/issues), choose one that interests you, and start contributing.
4. Spread the word about eLLMental!

Detailed instructions for community contributions can be found in our [Contributing Guide](website/CONTRIBUTING.md).

## License

The eLLMental project operates under the terms of the Apache License, Version 2.0. You can view the full license in the [LICENSE](LICENSE) file.

eLLMental is a proud open-source initiative by [The Agile Monkeys](https://www.theagilemonkeys.com/).

## Contact

Your feedback and questions are important to us. For any inquiries or issues, feel free to reach out to us at [info@theagilemonkeys.com](mailto:info@theagilemonkeys.com).