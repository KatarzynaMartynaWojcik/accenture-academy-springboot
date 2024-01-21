package com.accenture.academy.priest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriestDto {
    @NotNull(message="Name must not be null")
    @Pattern(regexp = "[A-Za-z]+")
    private String name;
    @Min(value =150, message = "Height must be above 150" )
    private Integer height;
    @Min(value =18, message = "Age must be above 18" )
    private Integer age;

}
