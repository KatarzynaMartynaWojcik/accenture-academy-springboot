package com.accenture.academy.priest;


import jakarta.validation.Valid;
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

//    @GetMapping(path = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    PriestDao getPriestById(@PathVariable Long id) {
//        return priestService.getPriestById(id);
//    }

    @GetMapping(path = "/{name}")
    ResponseEntity getPriestByName(@PathVariable String name) {
        try {
            return ResponseEntity
                    .status(200)
                    .body(priestService.getPriestByName(name));
        } catch (PriestNameNotFoundException exception) {
            return ResponseEntity
                    .status(404)
                    .body(exception.getMessage());
        }
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePriestById(@PathVariable Long id){
        priestService.deleteById(id);
    }

    @PutMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updatePriest(@RequestBody PriestDto priestDto, @PathVariable Long id){
        priestService.update(priestDto, id);
    }

    @PostMapping
    void addPriest(@RequestBody @Valid PriestDto priestDto){
        priestService.addPriestDto(priestDto);
    }
}