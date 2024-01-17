package com.accenture.academy.priest;

import com.accenture.academy.church.ChurchDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPriestRepository extends JpaRepository<PriestDao, Long> {
    Optional<PriestDao> findByName(String name);


}

