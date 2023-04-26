package com.afrimoov.afribelle.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_prestation")
public class Prestation extends BaseSaleItem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "duration_millisecs")
    private Long duration;

    @Column(name = "duration_format")
    private String durationStr;

    @Column(name = "country")
    private Long country;

    @Column(name = "city")
    private Long ville;

    @Column(name = "quartier")
    private Long quartier;

    @Column(name = "adresse")
    private Long adresse;

    @Column(name = "deplacement")
    private boolean deplacement;
}
