package com.accenture.academy.priest;

import com.accenture.academy.church.ChurchDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPriestRepository extends JpaRepository<PriestDao, Long> {
}
