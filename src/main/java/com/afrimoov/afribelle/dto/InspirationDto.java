package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InspirationDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("reviews")
    private Long nbReviews;

    @JsonProperty("total_notes")
    private Long totalNotes;

    @JsonProperty("views")
    private Long views;

    @JsonProperty("downloads")
    private Long downloads;

    @JsonProperty("favories")
    private Long favories;

    @JsonProperty("shares")
    private Long shares;

    @JsonProperty("name")
    private String titre;

    @JsonProperty("description")
    private String description;

    @JsonProperty("date_crea")
    private String dateAjout;

    @JsonProperty("lien")
    private String lien;

    @JsonProperty("local_name")
    private String localName;

    @JsonProperty("liked")
    private Boolean liked;
}
