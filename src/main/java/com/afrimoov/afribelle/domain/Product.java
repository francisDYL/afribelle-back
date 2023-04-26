package com.afrimoov.afribelle.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_product")
public class Product extends BaseSaleItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prestation_id")
    private Long prestionId;

    @Column(name = "country")
    private Long country;

    @Column(name = "city")
    private Long ville;

    @Column(name = "quartier")
    private Long quartier;

    @Column(name = "adresse")
    private Long adresse;
}
