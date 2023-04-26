package com.afrimoov.afribelle.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_pgeo")
public class Pgeo extends DomainTimeStamp{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lat")
    private Double latitude;

    @Column(name = "long")
    private Double longitude;

    @Column(name = "lat_deg")
    private Double latDeg;

    @Column(name = "long_deg")
    private Double longDeg;

    @OneToOne(mappedBy = "pgeo")
    private City city;


}
