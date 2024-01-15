package com.accenture.academy.church;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChurchService {

    private final ChurchRepository churchRepository;
    private ChurchMapper churchMapper = new ChurchMapper();

    List<ChurchDao> getAllChurches() {  // nie musi byc public package private wystarczy
        return churchRepository.findAll();
    }

    void addChurch(ChurchDao churchDao){

        churchRepository.save(churchDao);
    }

    void addChurchDto(ChurchDto churchDto){

        churchRepository.save(ChurchMapper.mapDtoToDao(churchDto));
    }
}
