package com.bootcamp.weekone.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "User", sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "User")
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String surname;

    @Column(length = 50)
    private String email;

    @Column(length = 15)
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    private boolean isActive;

}
