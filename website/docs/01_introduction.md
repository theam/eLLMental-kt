---
slug: /
---
# Introduction

Welcome to eLLMental, the ultimate toolkit for building AI-driven projects. Born with the intention of accelerate the creation of production-ready AI-driven applications and foster reusability of common patterns without reinventing the wheel, eLLMental focuses on providing high-quality, reusable components made available across a variety of programming languages.

eLLMental is built with [Kotlin](https://kotlinlang.org), a programming language with great multi-platform capabilities, that allows us to build libraries that integrate seamlessly across a variety of programming environments, currently supporting JVM languages like Java, Scala, and Kotlin itself out of the box, and upcoming support for Node, Mobile, and Python.

We invite you to join us on this exciting journey towards creating a streamlined, efficient, and platform-independent future for dependable, production-ready AI. Welcome aboard eLLMental!

## Components: What can you do with eLLMental?

The eLLMental project is still in an early stage of development, and it currently implements three different AI components:

1. **Embeddings store:** A component that abstracts a database or repository used to handle vector representations of words or phrases, known as embeddings. These embeddings can be used to compare the semantic similarity between two pieces of text, enabling the creation of powerful AI-driven applications like semantic search engines. eLLMental currently supports [Pinecone](https://www.pinecone.io/), and will add support for new databases in the future.
2. **Embedding generator:** A component that abstracts an embeddings model which is responsible for converting raw text data into representative embeddings. eLLMental currently supports [OpenAI](https://openai.com/) embeddings model, and will add support for new models in the future.
3. **Semantic search module:** A component that abstracts the process of searching for similarities in the vector store. It uses the embedding generator and embeddings store components to provide a seamless API that can be used by developers without having to worry about the underlying complexity and implementation details of the AI APIs.

## Why eLLMental?

In the current landscape of AI application development, we recognized some recurrent challenges that developers face. We developed eLLMental as a direct response to these challenges. Here's why we believe eLLMental is your ideal set of tools for AI development:

1. **Simplicity in Complexity:** AI application development can be daunting. With eLLMental's configurable and composable components, the complexity inherent in AI development becomes significantly manageable. We aim to make the AI development process as simple and intuitive as developing any other software.

2. **Readiness for Production:** From development to deployment, all features of eLLMental are crafted with a production-ready mindset.

3. **Scalability and Flexibility:** eLLMental is designed to evolve with your needs. Whether you're building a small application or working on an enterprise-level project, eLLMental is designed to fit in your project.

4. **Continuous Improvement:** eLLMental continuously evolves for better. With the support of our active community and dedicated team, we regularly implement improvements and introduce innovative features to make eLLMental even more powerful and user-friendly.

5. **Making AI Accessible:** AI shouldn't be an exclusive club. By providing tools that simplifies AI development, we aim to make this powerful technology accessible to every developer out there, irrespective of their background in AI.

In a nutshell, eLLMental is our commitment to make AI development as simple, accessible, and effective as possible. We invite you to experience this commitment firsthand as you set sail into your next AI project with eLLMental.

## Join the movement!

We'll need your help to build something that becomes really useful for everyone. There are many things you can do to make this vision a reality:

1. Join the conversation in our [Discord server](https://discord.gg/34cBbvjjAx).
2. Send us suggestions, questions, or feature requests by creating a [New Issue](https://github.com/theam/ellmental/issues/new).
3. Look at the [Open Issues](https://github.com/theam/ellmental/issues), choose one that interests you, and start contributing.
4. Spread the word about eLLMental!

You wanna try? Check out the [Getting Started](/docs/02_getting_started.md) guide to learn how to use eLLMental in your projects.
