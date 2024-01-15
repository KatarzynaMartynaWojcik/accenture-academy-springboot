package com.accenture.academy.priest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PriestDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer height;
    private Integer age;

    public PriestDao(String name, Integer height, Integer age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }
}
