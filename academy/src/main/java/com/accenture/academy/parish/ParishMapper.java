package com.accenture.academy.parish;

public class ParishMapper {

    static ParishDao mapDtoToDao(ParishDto parishDto){
        ParishDao parishDao = new ParishDao();

        parishDao.setChurchDao(parishDto.getChurchDao());
        parishDao.setPriestDao(parishDto.getPriestDao());
        parishDao.setMembers(parishDto.getMembers());

        return parishDao;
    }


}
