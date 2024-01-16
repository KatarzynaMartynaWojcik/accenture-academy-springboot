package com.accenture.academy.priest;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.church.ChurchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/priests")
@RequiredArgsConstructor
public class PriestRestController {

    private final PriestService priestService;

    @GetMapping
    List<PriestDao> getAllPriests() {
        return priestService.getAllPriests();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    PriestDao getPriestById(@PathVariable Long id) {
        return priestService.getPriestById(id);
    }
}