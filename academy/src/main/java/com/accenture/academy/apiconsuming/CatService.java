package com.accenture.academy.apiconsuming;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class CatService {
    @PostConstruct
    public void getCatFact() throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create("https://catfact.ninja/fact"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String response = httpResponse.body().toString();

        ObjectMapper objectMapper = new ObjectMapper();
        Cat cat = objectMapper.readValue(response, Cat.class);

        log.info("logging");
        log.info(response);

        log.info("Fact");
        log.info(cat.getFact());

        log.info("Length");
        log.info(String.valueOf(cat.getLength()));
    }
}
