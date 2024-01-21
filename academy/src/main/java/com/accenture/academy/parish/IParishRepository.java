package com.accenture.academy.parish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IParishRepository extends JpaRepository<ParishDao, Long> {

    @Query(value = "SELECT * FROM PARISHES", nativeQuery = true)
    ParishDao getMyCustomParishes();
    }
