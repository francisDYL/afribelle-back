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
@Table(name = "t_adresse")
public class Address extends DomainTimeStamp {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quartier_id")
    private Long quartierId;

    @Column(name = "quartier_name")
    private String quartierName;

    @Column(name = "city_id")
    private Long villeId;

    @Column(name = "city_name")
    private String villeName1;

    @Column(name = "country_id")
    private Long paysId;

    @Column(name = "country_name")
    private String paysName;

    @Column(name = "rue")
    private String rue;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "descrription")
    private String description;


    @Column(name = "pgeo")
    private Long geographicLocation;

    @Column(name = "format_str")
    private String formatStr;

    @OneToOne(mappedBy = "adresse")
    private PageEntity pageEntity;
}
