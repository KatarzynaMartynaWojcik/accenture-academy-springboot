package com.accenture.academy.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "MEMBER")
@RequiredArgsConstructor
public class MemberDao {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    public MemberDao(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
}
