package com.afrimoov.afribelle.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_category")
public class Category extends DomainTimeStamp{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cat_name")
    private String name;

    @Column(name = "illustration")
    private String illustration;

    @Column(name = "cat_type")
    private String type;

    @Column(name = "parent_id")
    private Long parentId;
}
