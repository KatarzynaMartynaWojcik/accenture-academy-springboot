package com.accenture.academy.apiconsuming;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Joke {
    private String type;
    private String setup;
    private String punchline;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
