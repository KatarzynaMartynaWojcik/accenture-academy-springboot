package com.accenture.academy.apiconsuming.geolocation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Places {
    private String type;
    private List<Object> features;

}
