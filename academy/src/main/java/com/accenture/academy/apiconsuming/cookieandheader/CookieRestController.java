package com.accenture.academy.apiconsuming.cookieandheader;

import com.accenture.academy.apiconsuming.Cat;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path ="/hello/cookie")
public class CookieRestController {
    private final ApiCatService apiCatService;
    @GetMapping(path = "/cats")
    void consumeApi() throws IOException, InterruptedException {
        Cat cat = apiCatService.getCatFact();

    }

    @GetMapping
    ResponseEntity getHelloCookie(HttpServletRequest request, HttpServletResponse response) {

        String apikey = request.getHeader("apikey");
        String ipAddress = request.getHeader("X-FORWARDED-For");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
            log.info(ipAddress);
        }
        try {
            return ResponseEntity
                    .status(200)
                    .header("ej", "ho")
                    .body(apiCatService.getCatFact());
        }catch (Exception exception){
            return ResponseEntity
                    .status(404)
                    .body(exception.getMessage());
        }

    }
}

