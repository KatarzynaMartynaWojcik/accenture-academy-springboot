package com.accenture.academy.priest;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PRIEST")
public class PriestDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name= "height")
    private Integer height;
    private Integer age;

    @Embedded
    Location location;

    public PriestDao(String name, Integer height, Integer age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }
}
