package com.accenture.academy.priest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PriestDto {
    @NotNull(message="Name must not be null")
  //  @Pattern(regexp = "[A-Z]")
    private String name;
  //  @NotBlank(message="Height must not be blank")
    private Integer height;
    @Min(value =18, message = "Age must be above 18" )
    private Integer age;

}
