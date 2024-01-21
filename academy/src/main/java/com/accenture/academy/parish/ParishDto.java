package com.accenture.academy.parish;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.member.MemberDao;
import com.accenture.academy.priest.PriestDao;
import lombok.Data;

import java.util.Set;

@Data
public class ParishDto {


    private PriestDao priestDao;
    private ChurchDao churchDao;
    private Set<MemberDao> members;

}
