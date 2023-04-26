package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryDto {

    @JsonProperty("cat_id")
    private Long id;

    @JsonProperty("cat_name")
    private String name;

    @JsonProperty("illustration")
    private String illustration;

    @JsonProperty("cat_type")
    private String type;

    @JsonProperty("parent_id")
    private Long parentId;

}
