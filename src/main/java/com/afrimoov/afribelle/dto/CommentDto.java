package com.afrimoov.afribelle.dto;

import com.afrimoov.afribelle.enums.Itemkind;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class CommentDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("note")
    private Integer note;

    @JsonProperty("message")
    private String message;

    @JsonProperty("date_creation")
    private Instant dateCreation = Instant.now();

    @JsonProperty("item_type")
    private Itemkind itemType;

    @JsonProperty("item_id")
    private Long itemId;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("illustration")
    private String illustration;
}
