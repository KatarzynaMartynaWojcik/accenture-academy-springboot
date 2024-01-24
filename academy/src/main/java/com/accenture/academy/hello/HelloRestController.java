package com.accenture.academy.hello;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//@Profile(value="dev")
public class HelloRestController {

    @GetMapping(path ="/hello")

    String getHello(HttpServletRequest request, HttpServletResponse response) {

       String apikey = request.getHeader("apikey");
       String ipAddress = request.getHeader("X-FORWARDED-For");
       if(ipAddress == null){
           ipAddress =request.getRemoteAddr();
           log.info(ipAddress);
       }

       log.info("Apikey = " + apikey);
        Cookie cookie = new Cookie("lolo", "jolo");
        response.addCookie(cookie);

        return "Hello World from Accenture";
    }
}
