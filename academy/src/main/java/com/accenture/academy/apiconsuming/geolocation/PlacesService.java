package com.accenture.academy.apiconsuming.geolocation;

import com.accenture.academy.apiconsuming.Joke;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlacesService {
    private final PlacesConfig config;

    @Value("${accenture.academy.api-key-from-value2}")
    private String apiKey;

// w app. properties ustawimy zeby klucz zmienial sie za kazdym razem

    @PostConstruct
     public Places getGeolocation() throws IOException, InterruptedException {



        HttpClient httpClient = HttpClient.newHttpClient();


        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create("https://api.geoapify.com/v2/places?categories=commercial.supermarket&filter=rect%3A10.716463143326969%2C48.755151258420966%2C10.835314015356737%2C48.680903341613316&limit=20&apiKey=" + config.getApiKey()))
                .build();

        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String response = httpResponse.body().toString();


        ObjectMapper objectMapper = new ObjectMapper();
        Places places = objectMapper.readValue(response, Places.class);


        log.info(httpResponse.body().toString());

        return places;
    }




}
