package com.accenture.academy.parish;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.member.MemberDao;
import com.accenture.academy.priest.PriestDao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Member;
import java.util.Set;

@Entity
@Data
@Table(name = "PARISH")
@NoArgsConstructor
public class ParishDao {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne (cascade = CascadeType.ALL)
    private PriestDao priestDao;
    @OneToOne (cascade = CascadeType.ALL)
    private ChurchDao churchDao;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "PARISH_ID")
    private Set<MemberDao> members;
    private Boolean isCementaryPresent;

    public ParishDao(PriestDao priestDao, ChurchDao churchDao, Set<MemberDao> members) {
        this.priestDao = priestDao;
        this.churchDao = churchDao;
        this.members = members;
    }
}
