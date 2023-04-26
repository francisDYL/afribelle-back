package com.afrimoov.afribelle.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.List;

@Data
@MappedSuperclass
public class BaseItem implements Serializable {

    @Column(name = "name")
    protected String name;

    @Column(name = "categoriesStr")
    protected String categoriesStr;

    @Column(name = "categories")
    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    protected List<String> categoriesList;

    @Column(name = "description")
    protected String description;

    @Column(name = "page_id")
    protected Long page;

    @Column(name = "user_id")
    protected Long user;

    @Column(name = "page_name")
    protected String pageName;

    @Column(name = "user_name")
    protected String userName;

    @Column(name = "illustration")
    protected String illustration;

    @Column(name = "views")
    protected Long views;

    @Column(name = "shares")
    protected Long shares;

    @Column(name = "downloads")
    protected Long downloads;

    @Column(name = "downloaded")
    protected Boolean downloaded;

    @Column(name = "shared")
    protected Boolean shared;

    @Column(name = "viewed")
    protected Boolean viewed ;

    @Column(name = "bookmarked")
    protected Boolean bookmarked;

    @Column(name = "purchased")
    protected Boolean purchased;

    @Column(name = "commented")
    protected Boolean commented;

    @Column(name = "reported")
    protected Boolean reported;

    @Column(name = "likes")
    protected Long likes;

    @Column(name = "comments")
    protected Long comments;

    @Column(name = "reports")
    protected Long reports;

    @Column(name = "sales")
    protected Long sales;

    @Column(name = "bookmarks")
    protected Long bookmarks;

    @Column(name = "total_sales")
    protected String totalSales;

    @Column(name = "tags")
    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    protected List<String> tags;

    @Column(name = "tagsStr")
    protected String tagsStr;

    @Column(name = "date_creation")
    protected String dateCreation;

    @Column(name = "url")
    protected String url;
}
