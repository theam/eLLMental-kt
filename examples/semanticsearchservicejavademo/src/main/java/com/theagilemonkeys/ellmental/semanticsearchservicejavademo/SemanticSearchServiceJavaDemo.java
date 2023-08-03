package com.theagilemonkeys.ellmental.semanticsearchservicejavademo;

import com.aallam.openai.client.OpenAI;
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel;;
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch;
import com.theagilemonkeys.ellmental.semanticsearchservicejavademo.config.JavaDemoConfig;
import com.theagilemonkeys.ellmental.semanticsearchservicejavademo.controller.SemanticSearchController;
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore;
import spark.Spark;

import static com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIClientKt.OpenAIClient;
import static spark.Spark.awaitInitialization;
import static spark.Spark.port;
import static spark.Spark.post;

public class SemanticSearchServiceJavaDemo {

    public static void main(String[] args) {
        JavaDemoConfig config = new JavaDemoConfig();

        OpenAI openAI = OpenAIClient(config.getOpenaiToken());
        OpenAIEmbeddingsModel openAIEmbeddingsModel = new OpenAIEmbeddingsModel(openAI);
        PineconeVectorStore pineconeVectorStore = new PineconeVectorStore(config.getPineconeToken(), config.getPineconeUrl());
        SemanticSearch semanticSearch = new SemanticSearch(openAIEmbeddingsModel, pineconeVectorStore);

        SemanticSearchController semanticSearchController = new SemanticSearchController(semanticSearch);

        port(8080);

        post("/learn", semanticSearchController.learn);
        post("/search", semanticSearchController.search);

        awaitInitialization();
        System.out.println("Spark server started");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                Spark.stop();
                System.out.println("Spark server stopped");
            }
        });
    }
}
