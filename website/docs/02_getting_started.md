# Getting started

eLLMental is a toolset for building AI-powered applications written in Kotlin, and it offers a variety of components
that you can use right away. In this guide, we will guide you through an example of how to use
the [SemanticSearch component](/api_docs/ellmental/com.theagilemonkeys.ellmental.semanticsearch/) to build an
intelligent note taking application for the terminal that learns from your notes and is able to find
relevant notes based on a query.

## Step 0: Create a new Kotlin application project

This can be done using your preferred IDE or using the command line. If you're using IntelliJ IDEA,
you can follow the steps below:

1. Open IntelliJ IDEA and click on `Create New Project`.
2. Select `New Project` in the left panel and then select `Kotlin` and `Gradle` in the right panel. Choose `Kotlin` as
   the Build DSL.
3. Click `Create` and then enter the project name and location.

## Step 1: Add the eLLMental dependencies using [JitPack](https://jitpack.io)

Import the eLLMental dependencies in your `build.gradle.kts` file as follows:

```kotlin
allprojects {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
}

dependencies {
    implementation("com.github.theam.ellmental:core:main-SNAPSHOT")
    implementation("com.github.theam.ellmental:semanticsearch:main-SNAPSHOT")
    implementation("com.github.theam.ellmental:vectorstore:main-SNAPSHOT")
    implementation("com.github.theam.ellmental:embeddingsmodel:main-SNAPSHOT")
    implementation("com.aallam.openai:openai-client:3.3.0")
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers"
    }
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
```

## Step 2: Creating the Note class

Let's create a `Note` class. This class will have two
properties: `id` type `Int` for the note identifier and `content` type `String` for the note content.

```kotlin
data class Note(
    val id: Int,
    val content: String
)
```

## Step 3: Initializing the SemanticSearch component

Before initializing the `SemanticSearch` component, we need to set up the `OpenAIEmbeddingsModel`
and `PineconeVectorStore`, which are two key components required by `SemanticSearch`.

You can initialize these components in their own function, so you can do stuff like loading the
tokens from your environment variables.

```kotlin
import com.aallam.openai.client.OpenAI
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore

fun embeddingsModel(): OpenAIEmbeddingsModel {
    val openaiToken = System.getenv("OPEN_AI_API_KEY")
    check(openaiToken != null) { "OPEN_AI_API_KEY environment variable is not set" }
    with(OpenAI(token = openaiToken)) {
        return OpenAIEmbeddingsModel()
    }
}

fun vectorStore(): PineconeVectorStore {
    val pineconeToken = System.getenv("PINECONE_API_KEY")
    check (pineconeToken != null) { "PINECONE_API_KEY environment variable is not set" }
    val pineconeUrl = System.getenv("PINECONE_URL")
    check (pineconeUrl != null) { "PINECONE_URL environment variable is not set" }
    return PineconeVectorStore(apiKey = pineconeToken, url = pineconeUrl)
}
```

Next, we will do the same for initializing the `SemanticSearch` instance. Import the `SemanticSearch` component
from eLLMental and create an instance using the functions you created above.

```kotlin
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore


fun semanticSearch(): SemanticSearch {
    val embeddingsModel = embeddingsModel()
    val vectorStore = vectorStore()
    with(embeddingsModel) {
        with(vectorStore) {
            return SemanticSearch()
        }
    }
}
```

## Step 4: Implementing the `learn` and `search` features

Let's implement the `learn` and `search` features to add new notes into the `SemanticSearch` index and find them
later.

```kotlin
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch

suspend fun learn(semanticSearch: SemanticSearch, note: Note) {
    semanticSearch.learn(SearchInput(listOf(note.content)))
}

suspend fun search(semanticSearch: SemanticSearch, query: String): List<String> {
    semanticSearch.search(query).entries.map {
        // Here entries can be mapped to your corresponding data models based on the returned `SemanticEntry` object
        // we just gonna return the id
        it.id.value
    }
}
```

## Step 5: Creating a main function

The only thing that's missing now is an application loop. Let's implement so in the `main` function.

```kotlin
fun main() = runBlocking {
    val semanticSearch = semanticSearch()
    println("Available commands: learn, search, quit\n")
    var shouldQuit = false
    while (!shouldQuit) {
        print("> ")
        when (readln()) {
            "help" -> {
                println("Available commands: learn, search, quit")
            }
            "learn" -> {
                println("Enter note content:")
                val txt = readln()
                val note = Note(
                  id = 1,
                  content = txt
                )
                learn(semanticSearch, note)
            }
            "search" -> {
                println("Enter query:")
                val query = readln()
                val results = search(semanticSearch, query)
                println(results)
            }
            "quit" -> {
                println("Bye!")
                shouldQuit = true
            }
            else -> {
                println("Invalid command")
            }
        }
    }
}
```

## Step 6: Running the application

Now you can run your application either from the IDE run button or from the command line using `./gradlew run`.

```text
Available commands: learn, search, quit
> learn

Enter note content:
This is a note about eLLMental, an open source library for building intelligent applications.

> search

Enter query:
eLLMental
[This is a note about eLLMental, an open source library for building intelligent applications.]

> quit
Bye!
```

This is how you can use the `SemanticSearch` component from eLLMental to build an intelligent note taking application
backend that learns from your notes and is able to find relevant notes based on a query.

[Here is a link to the repository](https://github.com/theam/ellmental-cli-notes-example) that contains this entire example.

Wanna learn more? Read the [Components](./Components.mdx)
page to discover the different components available in eLLMental, together with their thorough usage, and if you have
any question,
you are very welcome at the [community Discord server](https://discord.gg/34cBbvjjAx)!

## Additional sample code

In addition to this guide, you can find a simpler sample application that exposes the `SemanticSearch` component from
eLLMental as a REST API in
the [eLLMental Examples repository](https://github.com/theam/eLLMental/tree/main/examples/semanticsearchservicedemo).
