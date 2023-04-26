package com.afrimoov.afribelle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BaseItemDto {

    @JsonProperty("id")
    protected  Long id;

    @JsonProperty("name")
    protected  String name;

    @JsonProperty("categoriesStr")
    protected  String categoriesStr;

    @JsonProperty("categories")
    protected  List<String> categoriesList;

    @JsonProperty("description")
    protected  String description;

    @JsonProperty("page_id")

    protected  Long page;

    @JsonProperty("user_id")
    protected  Long user;

    @JsonProperty("page_name")
    protected  String pageName;

    @JsonProperty("user_name")
    protected  String userName;

    @JsonProperty("illustration")
    protected  String illustration;

    @JsonProperty("views")
    protected  Long views;

    @JsonProperty("shares")
    protected  Long shares;

    @JsonProperty("downloads")
    protected  Long downloads;

    @JsonProperty("downloaded")
    protected  Boolean downloaded;

    @JsonProperty("shared")
    protected  Boolean shared;

    @JsonProperty("viewed")
    protected  Boolean viewed ;

    @JsonProperty("bookmarked")
    protected  Boolean bookmarked;

    @JsonProperty("purchased")
    protected  Boolean purchased;

    @JsonProperty("commented")
    protected  Boolean commented;

    @JsonProperty("reported")
    protected  Boolean reported;

    @JsonProperty("likes")
    protected  Long likes;

    @JsonProperty("comments")
    protected  Long comments;

    @JsonProperty("reports")
    protected  Long reports;

    @JsonProperty("sales")
    protected  Long sales;

    @JsonProperty("bookmarks")
    protected  Long bookmarks;

    @JsonProperty("total_sales")
    protected  String totalSales;

    @JsonProperty("tags")
    protected  List<String> tags;

    @JsonProperty("tagsStr")
    protected  String tagsStr;

    @JsonProperty("date_creation")
    protected  String dateCreation;

    @JsonProperty("url")
    protected  String url;
}
