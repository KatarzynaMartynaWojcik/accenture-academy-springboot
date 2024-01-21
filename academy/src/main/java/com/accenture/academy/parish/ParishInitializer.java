//package com.accenture.academy.parish;
//
//import com.accenture.academy.church.ChurchDao;
//import com.accenture.academy.member.MemberDao;
//import com.accenture.academy.priest.PriestDao;
//import jakarta.annotation.PostConstruct;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Data
//@Component
//@RequiredArgsConstructor
//public class ParishInitializer {
//    private final ParishService parishService;
//
//    @PostConstruct
//    void initParishes() {
//        ParishDao parishDao = new ParishDao(
//                new PriestDao("Władysław", 165, 50),
//                new ChurchDao("Kościół Mariolki", "Warszawa", 40, 100, 10000.0),
//                Set.of(new MemberDao("Aleksandra", "Kowalska", "1985"),
//                        new MemberDao("Wojciech", "Adamski", "2000"))
//        );
//
//        ParishDto parishDto = ParishMapper.mapDaoToDto(parishDao);
//
//        parishService.addParish(parishDto);
//    }
//}
