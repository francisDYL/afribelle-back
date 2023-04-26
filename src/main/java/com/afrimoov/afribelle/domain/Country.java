package com.afrimoov.afribelle.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_country")
public class Country extends DomainTimeStamp{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "flag")
    private Long flag;

    @Column(name = "flag_str")
    private String flagStr;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "pgeo_id")
    private Long geographicLocation;

    @Column(name = "illustration")
    private String illustration;

    @Column(name = "description")
    private String description;

    @Column(name = "activated")
    private boolean activated = true;

    @OneToMany(mappedBy = "country")
    private Set<PageEntity> pageEntity;

}
