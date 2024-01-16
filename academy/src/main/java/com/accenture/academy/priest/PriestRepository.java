package com.accenture.academy.priest;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.church.IChurchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PriestRepository {

    private final IPriestRepository iPriestRepository;
    public List<PriestDao> findAll() {

        return iPriestRepository.findAll();
    }

    public void save(PriestDao priestDao) {

        iPriestRepository.save(priestDao);
    }

    public Optional<PriestDao> findById(Long id) {
        return iPriestRepository.findById(id);
    }
}
