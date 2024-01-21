//package com.accenture.academy.apiconsuming.cookieandheader;
//
//import com.accenture.academy.apiconsuming.Joke;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//
//@Service
//public class CatService {
//    @PostConstruct
//    public void getCatFact() throws IOException, InterruptedException {
//
//        HttpClient httpClient = HttpClient.newHttpClient();
//        HttpRequest httpRequest = HttpRequest
//                .newBuilder()
//                .GET()
//                .uri(URI.create("https://catfact.ninja/fact"))
//                .build();
//        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//        String response = httpResponse.body().toString();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        Cat cat = objectMapper.readValue(response, Cat.class);
//    }
//}