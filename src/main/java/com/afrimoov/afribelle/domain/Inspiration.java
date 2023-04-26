package com.afrimoov.afribelle.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_inspiration")
public class Inspiration extends DomainTimeStamp {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="reviews")
    private Long nbReviews;

    @Column(name ="total_notes")
    private Long totalNotes;

    @Column(name ="views")
    private Long views;

    @Column(name ="downloads")
    private Long downloads;

    @Column(name ="favories")
    private Long favories;

    @Column(name ="shares")
    private Long shares;

    @Column(name ="name")
    private String titre;

    @Column(name ="description")
    private String description;

    @Column(name ="date_crea")
    private String dateAjout;

    @Column(name ="lien")
    private String lien;

    @Column(name ="local_name")
    private String localName;

    @Column(name ="liked")
    private Boolean liked;
}
