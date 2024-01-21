package com.accenture.academy;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.member.MemberDao;
import com.accenture.academy.parish.ParishDao;
import com.accenture.academy.parish.ParishService;
import com.accenture.academy.priest.PriestDao;
import com.accenture.academy.priest.PriestService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final PriestService priestService;
    private final ParishService parishService;


    @PostConstruct
    void initData(){
        PriestDao priestDao = new PriestDao(
                "Kazimierz",
                180,
                46
        );
        priestService.addPriest(priestDao);


        ParishDao parishDao = new ParishDao(new PriestDao("Igor", 160, 60),
                new ChurchDao("Sw. Katarzyny","Ldzi", 150,5000,70.00),
                Set.of(new MemberDao("MArcin","nazwisko","1980"),
                        new MemberDao("KAcper", "Kowalski", "1950")));

        parishService.addParish(parishDao);
    }
}
