package com.kurztrip.packages.http;


import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Http {
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2).build();

    public Http() {
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }
}

