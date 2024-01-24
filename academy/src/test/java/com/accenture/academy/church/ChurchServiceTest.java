package com.accenture.academy.church;

import com.accenture.academy.church.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ChurchServiceTest{
    @Mock
    ChurchRepository churchRepository;
    @InjectMocks
    ChurchService churchService;

    @Test
    void testGetAllChurches(){
        //given
        ChurchDao churchDao = new ChurchDao(
                "Sw. Katarzyny",
                "Ldzi",
                150,
                5000,
                70.00);

        ChurchDao churchDao1 = new ChurchDao(
                "Sw. Wojciecha",
                "Wawa",
                90,
                10000,
                80.00);

        Mockito.when(churchRepository.findAll()).thenReturn(List.of(churchDao,churchDao1)); //kontekst nie wstaje, dlatego musimy podac co ma wyswietlic jak zostanie wywolana metoda
        //when + then
        assertEquals(List.of(churchDao,churchDao1), churchService.getAllChurches());// sprawdzamy czy church serwis zwroci nam ta liste
    }

    @Test
    void testAddChurch() {
        //given
        ChurchDao churchDao = new ChurchDao(
                "Sw. Zofii",
                "Radom",
                15,
                5000,
                70.00);
        ChurchDao churchDao1 = new ChurchDao(
                "Sw. Wojciecha",
                "Wawa",
                90,
                10000,
                80.00);


        churchService.addChurch(churchDao);
        Mockito.verify(churchRepository, Mockito.times(1)).save(churchDao);

        churchService.addChurch(churchDao1);
        Mockito.verify(churchRepository, Mockito.times(1)).save(churchDao);
    }

    @Test
    void testGetChurchByIdHappy() {
        ChurchDao churchDao = new ChurchDao(
                "Sw. Zofii",
                "Radom",
                15,
                5000,
                70.00);

    Mockito.when(churchRepository.findById(1L)).thenReturn(Optional.of(churchDao));
    Assertions.assertEquals(churchDao, churchService.getChurchById(1L));
    }

    @Test
    void testGetChurchByIdException() {

        Mockito.when(churchRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(ChurchNotFoundException.class, ()->churchService.getChurchById(any()));
    }

    @Test
    void testDeleteChurchById() {
        churchService.deleteById(1L);
        Mockito.verify(churchRepository, Mockito.times(1)).deleteById(1L);
    }

    @Test
    void testUpdateChurch() {
        ChurchDto churchDto = new ChurchDto(
                "Sw. Zofii",
                "Radom",
                15,
                5000,
                70.00);

        churchService.update(churchDto, any());
        Mockito.verify(churchRepository, Mockito.times(1)).save(any());
    }
}