package com.accenture.academy.apiconsuming;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class JokeService {
    private final HttpClient httpClient;
    @PostConstruct
    public void getJoke() throws IOException, InterruptedException {


        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create("https://official-joke-api.appspot.com/random_joke"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
       String response = httpResponse.body().toString();

        ObjectMapper objectMapper = new ObjectMapper();
        Joke joke = objectMapper.readValue(response, Joke.class);

        System.out.println("Sout");
        System.out.println(response);

        log.info("logging");
        log.info(response);

        log.info("Type");
        log.info(joke.getType());

        log.info("Punchline");
        log.info(joke.getPunchline());

        log.info("Setup");
        log.info(joke.getSetup());

        log.info("Id");
        log.info(String.valueOf(joke.getId()));

    }

    public Joke getRandomJoke() throws IOException, InterruptedException {


        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create("https://official-joke-api.appspot.com/random_joke"))
                .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String response = httpResponse.body().toString();

        ObjectMapper objectMapper = new ObjectMapper();
        Joke joke = objectMapper.readValue(response, Joke.class);

        log.info("Type");
        log.info(joke.getType());

        log.info("Punchline");
        log.info(joke.getPunchline());

        log.info("Setup");
        log.info(joke.getSetup());

        log.info("Id");
        log.info(String.valueOf(joke.getId()));

        return joke;



    }

}
