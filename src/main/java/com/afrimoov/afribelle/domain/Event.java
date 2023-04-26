package com.afrimoov.afribelle.domain;

import com.afrimoov.afribelle.enums.EventKind;
import com.afrimoov.afribelle.enums.Itemkind;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_event")
public class Event extends DomainTimeStamp {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "valeur")
    private Long value;

    @Column(name = "item_type")
    @Enumerated(EnumType.STRING)
    private Itemkind itemType;

    @Column(name = "event_type")
    @Enumerated(EnumType.STRING)
    private EventKind eventType;

    @Column(name = "date_creation")
    private Instant dateCreation ;

}
