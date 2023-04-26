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
@Table(name = "t_district")
public class District extends DomainTimeStamp {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="illustration")
    private String illustration;

    @Column(name ="description")
    private String description;

    @Column(name ="pgeo_id")
    private Long geographicLocation;

    @Column(name ="ville_id")
    private Long cityId;

    @Column(name ="ville_name")
    private String cityName;

    @Column(name ="country_id")
    private Long paysId;

    @Column(name ="country_name")
    private String paysName;

    @Column(name ="format_str")
    private String formatStr;

    @OneToMany(mappedBy = "quartier")
    private Set<PageEntity> pageEntity;
}
