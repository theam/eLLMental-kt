package com.theagilemonkeys.ellmental.semanticsearchservicedemo;

import com.aallam.openai.client.OpenAI;
import com.theagilemonkeys.ellmental.core.api.API;
import com.theagilemonkeys.ellmental.core.api.ApiDefinition;
import com.theagilemonkeys.ellmental.core.api.RunHttp;
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel;
import com.theagilemonkeys.ellmental.semanticsearch.SearchInput;
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch;
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;

import static spark.Spark.port;

/**
 * Demo configuration of the Semantic Search Service.
 *
 * Uses:
 *  * OpenAI's embeddings model
 *  * Pinecone as vector store
 *  * HTTP as API
 */
public class SemanticSearchServiceDemo {

    public static API<SemanticSearch> buildApi() {
        String envDir = System.getenv("DEBUG_DOTENV");
        if (envDir == null || envDir.trim().isEmpty()) {
            envDir = ".";
        }
        Dotenv dotenv = Dotenv.configure()
                .directory(envDir)
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        String openaiToken = dotenv.get("OPEN_AI_API_KEY");
        if (openaiToken == null || openaiToken.trim().isEmpty()) {
            throw new IllegalStateException("OPEN_AI_API_KEY environment variable not set");
        }
        String pineconeToken = dotenv.get("PINECONE_API_KEY");
        if (pineconeToken == null || pineconeToken.trim().isEmpty()) {
            throw new IllegalStateException("PINECONE_API_KEY environment variable not set");
        }
        String pineconeUrl = dotenv.get("PINECONE_URL");
        if (pineconeUrl == null || pineconeUrl.trim().isEmpty()) {
            throw new IllegalStateException("PINECONE_URL environment variable not set");
        }

        OpenAI openAI = new OpenAI(openaiToken);
        OpenAIEmbeddingsModel embeddingsModel = openAI.openAIEmbeddingsModel();
        PineconeVectorStore vectorStore = new PineconeVectorStore(pineconeToken, pineconeUrl);
        SemanticSearch semanticSearch = new SemanticSearch();

        ApiDefinition<SemanticSearch> apiDefinition = new ApiDefinition<SemanticSearch>() {
            @Override
            public void define() {
                write("learn", semanticSearch::learn);
                read("search", semanticSearch::search);
            }
        };

        return apiDefinition.toApi();
    }

    public static void main(String[] args) {
        port(8080);
        buildApi().runHttp();
    }
}
