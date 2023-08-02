package com.theagilemonkeys.ellmental.semanticsearchservicejavademo;

import com.aallam.openai.client.OpenAI;
import com.aallam.openai.client.OpenAIKt;
import com.theagilemonkeys.ellmental.core.api.API;
import com.theagilemonkeys.ellmental.core.api.HTTPKt;
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel;
import com.theagilemonkeys.ellmental.semanticsearch.SearchInput;
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch;
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore;
import io.github.cdimascio.dotenv.Dotenv;
import kotlin.jvm.JvmClassMappingKt;
import org.http4k.client.OkHttp;

import java.util.function.Consumer;

import static com.theagilemonkeys.ellmental.core.api.APIKt.apiDefinition;

public class SemanticSearchServiceJavaDemo {
    private static API<SemanticSearch> buildApi() {
        String envDir = System.getenv("DEBUG_DOTENV");
        if (envDir == null || envDir.trim().isEmpty()) {
            envDir = ".";
        }

        Dotenv env = Dotenv.configure()
                .directory(envDir)
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        String openaiToken = env.get("OPEN_AI_API_KEY");
        if (openaiToken == null || openaiToken.trim().isEmpty()) {
            throw new IllegalStateException("OPEN_AI_API_KEY environment variable not set");
        }

        String pineconeToken = env.get("PINECONE_API_KEY");
        if (pineconeToken == null || pineconeToken.trim().isEmpty()) {
            throw new IllegalStateException("PINECONE_API_KEY environment variable not set");
        }

        String pineconeUrl = env.get("PINECONE_URL");
        if (pineconeUrl == null || pineconeUrl.trim().isEmpty()) {
            throw new IllegalStateException("PINECONE_URL environment variable not set");
        }

        OpenAIKt.openAI = new OpenAI(openaiToken);
        OpenAIEmbeddingsModel embeddingsModel = new OpenAIEmbeddingsModel();
        PineconeVectorStore vectorStore = new PineconeVectorStore(pineconeToken, pineconeUrl, new OkHttp());
        SemanticSearch semanticSearch = new SemanticSearch();

        API<SemanticSearch> api = apiDefinition(JvmClassMappingKt.getKotlinClass(SemanticSearch.class), semanticSearch);

        api.write("learn", (Consumer<SearchInput>) s -> semanticSearch.learn(s));
        api.read("search", (Consumer<String>) s -> semanticSearch.search(s));

        return api;
    }

    public static void main(String[] args) {
        API<SemanticSearch> api = buildApi();
        HTTPKt.runHttp(api, 8080);
    }
}