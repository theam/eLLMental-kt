# Getting started

eLLMental is a toolset for building AI-powered applications written in Kotlin, and it offers a variety of components that you can use right away. In this guide, we will guide you through an example of how to use the [SemanticSearch component](/api_docs/ellmental/com.theagilemonkeys.ellmental.semanticsearch/) from a Spring Boot application to build an intelligent note taking application backend that learns from your notes and is able to find relevant notes based on a query.

## Step 1: Setting up your Spring Boot application

Create a new Spring Boot project if you don't have one already set up. You can follow the official [Spring Initializr](https://start.spring.io/) documentation to create a new Spring Boot application or use your preferred IDE to initialize a new project.

## Step 2: Add the ellmental dependency using [JitPack](https://jitpack.io)

Import the eLLMental dependencies in your `build.gradle.kts` file as follows:

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

## Step 3: Creating the Note object

Let's create a `Note` object under `src/main/kotlin/your-package-name` directory. This class will have two properties: `id` type `Int` for the note identifier and `content` type `String` for the note content.

```kotlin
package your.package.name

data class Note(
    val id: Int,
    val content: String
)
```

## Step 4: Initializing the SemanticSearch component

Before initializing the `SemanticSearch` component, we need to set up the `OpenAIEmbeddingsModel` and `PineconeVectorStore`, which are two key components required by `SemanticSearch`.

Initialize these components under a new Spring Configuration class where you will load the tokens from your environment variables.

```kotlin
package your.package.name

import com.aallam.openai.client.OpenAI
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ELLMentalConfiguration {

    @Bean
    fun embeddingsModel(): OpenAIEmbeddingsModel {
        val openaiToken = System.getenv("OPEN_AI_API_KEY")
        with(OpenAI(token = openaiToken)) {
            return OpenAIEmbeddingsModel()
        }
    }

    @Bean
    fun vectorStore(): PineconeVectorStore {
        val pineconeToken = System.getenv("PINECONE_API_KEY")
        val pineconeUrl = System.getenv("PINECONE_URL")
        return PineconeVectorStore(apiKey = pineconeToken, url = pineconeUrl)
    }
}
```

Next, create a `SemanticSearchService` to wrap your `SemanticSearch` instance. Import the `SemanticSearch` component from eLLMental and create an instance using the spring managed `OpenAIEmbeddingsModel` and `PineconeVectorStore`.

```kotlin
package your.package.name

import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore
import org.springframework.stereotype.Service

@Service
class SemanticSearchService(private val embeddingsModel: OpenAIEmbeddingsModel, 
                            private val vectorStore: PineconeVectorStore) {

    private val semanticSearch: SemanticSearch

    // Initialize SemanticSearch in the constructor
    init {
        with(embeddingsModel) {
            with(vectorStore) {
                semanticSearch = SemanticSearch()
            }
        }
    }
}
```

## Step 5: Implementing the `learn` and `search` methods

Add the `learn` and `search` methods in your service to add new notes into the `SemanticSearch` index and search them later.

```kotlin
package your.package.name

import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Service

@Service
class SemanticSearchService(private val embeddingsModel: OpenAIEmbeddingsModel, 
                            private val vectorStore: PineconeVectorStore) {

    ...

    fun learn(note: Note) {
        runBlocking {
            semanticSearch.learn(SearchInput(listOf(note.content)))
        }
    }

    fun search(query: String): List<String> {
        return runBlocking {
            semanticSearch.search(query).entries.map { 
                // Here entries can be mapped to your corresponding data models based on the returned `SemanticEntry` object
            }
        }
    }
}
```

## Step 7: Creating the controller

Create a controller to expose the `learn` and `search` methods from your service. This controller will have two endpoints: `POST /notes` to add new notes and `GET /notes` to search for notes based on a query.

```kotlin
package your.package.name

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notes")
class NoteController(private val semanticSearchService: SemanticSearchService) {

    @PostMapping
    fun learn(@RequestBody note: Note): ResponseEntity<Unit> {
        semanticSearchService.learn(note)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun search(@RequestParam query: String): ResponseEntity<List<String>> {
        return ResponseEntity(semanticSearchService.search(query), HttpStatus.OK)
    }
}
```

## Step 8: Running the application

Run your application and test the endpoints using your preferred tool. You can use the following curl commands to test the endpoints:

```bash
curl --location --request POST 'http://localhost:8080/notes' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "content": "This is a note about eLLMental"
}'
```

```bash
curl --location --request GET 'http://localhost:8080/notes?query=note about eLLMental'
```

You should get a response similar to the following:

```json
[
    {
        "id": 1,
        "content": "This is a note about eLLMental"
    }
]
```

This is how you can use the `SemanticSearch` component from eLLMental to build an intelligent note taking application backend that learns from your notes and is able to find relevant notes based on a query. Please refer to the components page to learn more about the different components available in eLLMental, and if you have any question, feel free to join the [community Discord server](https://discord.gg/34cBbvjjAx)!

## Additional sample code

In addition to this guide, you can find a simpler sample application that exposes the `SemanticSearch` component from eLLMental as a REST API in the [eLLMental Examples repository](https://github.com/theam/eLLMental/tree/main/examples/semanticsearchservicedemo).
