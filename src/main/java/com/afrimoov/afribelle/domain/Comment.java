package com.afrimoov.afribelle.domain;

import com.afrimoov.afribelle.enums.Itemkind;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_comment")
public class Comment extends DomainTimeStamp {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "note")
    private Integer note;

    @Column(name = "message")
    private String message;

    @Column(name = "date_creation")
    private Instant dateCreation = Instant.now();

    @Column(name = "item_type")
    private Itemkind itemType;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "illustration")
    private String illustration;
}
