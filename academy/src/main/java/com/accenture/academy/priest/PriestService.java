package com.accenture.academy.priest;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.church.ChurchMapper;
import com.accenture.academy.church.ChurchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriestService {
    private final PriestRepository priestRepository;
    List<PriestDao> getAllPriests() {

        return priestRepository.findAll();
    }

    public void addPriest(PriestDao priestDao){

        priestRepository.save(priestDao);
    }

    public PriestDao getPriestById(Long id){
        return priestRepository
                .findById(id)
                .orElseThrow(() -> new PriestNotFoundException("Priest with " + id + " not found"));
    }

    public PriestDao getPriestByName(String name) {
        return priestRepository
                .findByName(name)
                .orElseThrow(() -> new PriestNameNotFoundException("Priest name " + name + " not found"));
    }

    public void deleteById(Long id) {
        priestRepository.deleteById(id);
    }

    public void update(PriestDto priestDto, Long id) {
        priestRepository.save(PriestMapper.mapDtoToDao(priestDto, id));
    }

    public void addPriestDto(PriestDto priestDto) {
        priestRepository.save(PriestMapper.mapDtoToDao(priestDto));
    }
}
