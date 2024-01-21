package com.accenture.academy.apiconsuming.geolocation;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "accenture.academy")
@Data
@Component
public class GeolocationConfig {


   private String apiKey;

}
//mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Daccenture.academy.apikey=57fa762d94b94cc194fee3860373146a"