package com.bootcamp.weekone.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user_comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserComment {

    @Id
    @SequenceGenerator(name = "UserComment", sequenceName = "USER_COMMENT_ID_SEQ")
    @GeneratedValue(generator = "UserComment")
    private Long id;

    @Column(length = 500)
    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;

    @Column
    private Long productId;

    @ManyToOne
    private User user;
}
