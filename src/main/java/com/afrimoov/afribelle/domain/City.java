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
@Table(name = "t_city")
public class City extends DomainTimeStamp{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="country_id")
    private Long paysId;

    @Column(name ="name")
    private String name;

    @Column(name ="country_name")
    private String paysName;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "pgeo_id", referencedColumnName = "id")
    private Pgeo pgeo;

    @Column(name ="illustration")
    private String illustration;

    @Column(name ="description")
    private String description;

    @OneToMany(mappedBy = "ville")
    private Set<PageEntity> pageEntity;
}
