package com.theagilemonkeys.ellmental.semanticsearchservicejavademo.config;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;

@Getter
public class JavaDemoConfig {
    private final String openaiToken;
    private final String pineconeToken;
    private final String pineconeUrl;

    public JavaDemoConfig() {
        Dotenv env = getDotenv();
        this.openaiToken = getOpenAIKey(env);
        this.pineconeToken = getPineconeToken(env);
        this.pineconeUrl = getPinecodeUrl(env);
    }

    private String getPinecodeUrl(Dotenv env) {
        String pineconeUrl = env.get("PINECONE_URL");
        if (pineconeUrl == null || pineconeUrl.trim().isEmpty()) {
            throw new IllegalStateException("PINECONE_URL environment variable not set");
        }

        return pineconeUrl;
    }

    private String getPineconeToken(Dotenv env) {
        String pineconeToken = env.get("PINECONE_API_KEY");
        if (pineconeToken == null || pineconeToken.trim().isEmpty()) {
            throw new IllegalStateException("PINECONE_API_KEY environment variable not set");
        }

        return pineconeToken;
    }

    private String getOpenAIKey(Dotenv env) {
        String openaiToken = env.get("OPEN_AI_API_KEY");
        if (openaiToken == null || openaiToken.trim().isEmpty()) {
            throw new IllegalStateException("OPEN_AI_API_KEY environment variable not set");
        }

        return openaiToken;
    }

    private Dotenv getDotenv() {
        String envDir = System.getenv("DEBUG_DOTENV");
        if (envDir == null || envDir.trim().isEmpty()) {
            envDir = ".";
        }

        return Dotenv.configure()
                .directory(envDir)
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
    }
}
