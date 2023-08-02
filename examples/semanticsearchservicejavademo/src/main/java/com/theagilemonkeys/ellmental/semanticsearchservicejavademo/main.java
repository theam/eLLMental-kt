package com.theagilemonkeys.ellmental.semanticsearchservicejavademo;

import com.theagilemonkeys.ellmental.core.api.API;
import com.theagilemonkeys.ellmental.core.api.HTTPKt;
import com.theagilemonkeys.ellmental.core.api.Handler;
import com.theagilemonkeys.ellmental.semanticsearch.SearchInput;
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch;
import io.github.cdimascio.dotenv.Dotenv;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;

import java.util.Map;

public class main {

    private static void checkEnvVars() {
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
    }

    private static API<SemanticSearch> buildApi() {
        checkEnvVars();

        SemanticSearch semanticSearch = new SemanticSearch();
        API<SemanticSearch> api = new API<>(JvmClassMappingKt.getKotlinClass(SemanticSearch.class));
        api.setReadOperations(getReadOperations(semanticSearch));
        api.setWriteOperations(getWriteOperations(semanticSearch));

        return api;
    }

    private static Map<String, Handler<Object, Object>> getWriteOperations(SemanticSearch semanticSearch) {
        Map<String, Handler<Object, Object>> writeOperations = Map.of();
        Handler<Object, Object> writeHandler = new Handler<>("learn", SearchInput.class, Unit.class,
                (SearchInput s) -> semanticSearch.learn(s));

        writeOperations.put("learn", writeHandler);

        return writeOperations;
    }

    private static Map<String, Handler<Object, Object>> getReadOperations(SemanticSearch semanticSearch) {
        Map<String, Handler<Object, Object>> readOperations = Map.of();
        Handler<Object, Object> writeHandler = new Handler<>("search", String.class, Unit.class,
                (String s) -> semanticSearch.search(s));
        readOperations.put("search", writeHandler);

        return readOperations;
    }

    public static void main(String[] args) {
        API<SemanticSearch> api = buildApi();
        HTTPKt.runHttp(api, 8080);
    }
}
