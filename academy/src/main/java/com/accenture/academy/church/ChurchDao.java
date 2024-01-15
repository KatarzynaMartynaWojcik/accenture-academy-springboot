package com.accenture.academy.church;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ChurchDao {
    public ChurchDao(String name, String nameOfCity, Integer numberOfSeats, Integer numberOfMembers, Double budget) {
        this.name = name;
        this.nameOfCity = nameOfCity;
        this.numberOfSeats = numberOfSeats;
        this.numberOfMembers = numberOfMembers;
        this.budget = budget;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String nameOfCity;
    private Integer numberOfSeats;
    private Integer numberOfMembers;
    private Double budget;
}
