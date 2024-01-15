package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChurchService {

    private final ChurchRepository churchRepository;
    List<ChurchDao> getAllChurches() {  // nie musi byc public package private wystarczy
        return churchRepository.findAll();
    }

    void addChurch(ChurchDao churchDao){
        churchRepository.save(churchDao);
    }
}
