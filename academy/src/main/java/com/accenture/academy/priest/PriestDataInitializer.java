package com.accenture.academy.priest;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PriestDataInitializer {
    private final PriestService priestService;

    @PostConstruct
    void initPriests(){
        PriestDao priestDao = new PriestDao(
                "Kazimierz",
                180,
                46
        );
        priestService.addPriest(priestDao);
    }
}
