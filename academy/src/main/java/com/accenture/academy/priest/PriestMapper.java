package com.accenture.academy.priest;


public class PriestMapper {
    static PriestDao mapDtoToDao(PriestDto priestDto, Long id){
        PriestDao priestDao = new PriestDao();
        priestDao.setId(id);
        priestDao.setName(priestDto.getName());
        priestDao.setHeight(priestDto.getHeight());
        priestDao.setAge(priestDto.getAge());


        return priestDao;
    }
}
