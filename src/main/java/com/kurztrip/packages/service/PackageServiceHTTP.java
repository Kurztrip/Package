package com.kurztrip.packages.service;

import com.kurztrip.packages.http.Http;
import com.kurztrip.packages.model.Package;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class PackageServiceHTTP {
    private final Http httpClient = new Http();

    public PackageServiceHTTP() {
    }

    public String getAll() throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(""))
                .setHeader("Content-type", "application/json")
                .build();
        HttpResponse<String> response = httpClient.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String getPackage(int id) throws IOException, InterruptedException { // uri = uri del servidor
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(""+ id))
                .setHeader("Content-type", "application/json")
                .build();
        HttpResponse<String> response = httpClient.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public void deletePackage(int id) throws IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .DELETE()
                .uri(URI.create(""+ id))
                .setHeader("Content-type", "application/json")
                .build();
        HttpResponse<String> response = httpClient.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

}
