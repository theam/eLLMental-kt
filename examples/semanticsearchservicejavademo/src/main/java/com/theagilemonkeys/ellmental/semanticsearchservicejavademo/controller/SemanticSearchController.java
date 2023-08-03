package com.theagilemonkeys.ellmental.semanticsearchservicejavademo.controller;

import com.google.gson.Gson;
import com.theagilemonkeys.ellmental.semanticsearch.SearchInput;
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch;
import lombok.RequiredArgsConstructor;
import spark.Request;
import spark.Response;
import spark.Route;

@RequiredArgsConstructor
public class SemanticSearchController {
    private final SemanticSearch semanticSearch;
    public Route learn = (Request request, Response response) -> {
        SearchInput searchInput = new Gson().fromJson(request.body(), SearchInput.class);
        return this.semanticSearch.learn(searchInput);
    };
    public Route search = (Request request, Response response) -> {
        String text = new Gson().fromJson(request.body(), String.class);
        return this.semanticSearch.search(text).get();
    };
}
