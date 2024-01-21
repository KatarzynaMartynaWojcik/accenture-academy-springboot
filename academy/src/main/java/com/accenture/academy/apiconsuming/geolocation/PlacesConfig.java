package com.accenture.academy.apiconsuming.geolocation;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "accenture.kasia.academy")
@Data
@Component
public class PlacesConfig {

    private String apiKey;

}
