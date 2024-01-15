package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/churches")
@RequiredArgsConstructor
public class ChurchRestController {

    private final ChurchService churchService;

    @GetMapping
    List<ChurchDao> getAllChurches(){
//        ChurchDto churchDto = new ChurchDto(
//                "Kościół św. Krzyża",
//                "Warszawa",
//                150,
//                10000,
//                20000.00
//        );
        return churchService.getAllChurches();
    }
}
