package com.afrimoov.afribelle.dto;

import com.afrimoov.afribelle.enums.EventKind;
import com.afrimoov.afribelle.enums.Itemkind;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
public class EventDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("value")
    private Long value = 1L;

    @JsonProperty("event_type")
    private EventKind eventType;

    @JsonProperty("date_creation")
    private Instant dateCreation = Instant.now();

    @JsonProperty("item_type")
    private Itemkind itemType;

    @JsonProperty("item_id")
    private Long itemId;
}
