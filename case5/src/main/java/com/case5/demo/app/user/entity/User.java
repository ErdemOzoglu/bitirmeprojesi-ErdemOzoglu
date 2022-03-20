package com.case5.demo.app.user.entity;

import com.case5.demo.app.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USER_TABLE")
@Getter
@Setter
public class User extends BaseEntity {

    @Id
    @SequenceGenerator(name = "User", sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "User")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 40)
    private String name;

    @Column(name = "SURNAME", nullable = false, length = 40)
    private String surname;

    @Column(name = "USER_NAME", nullable = false, length = 50, unique = true)
    private String userName;

    @Column(name = "PASSWORD", nullable = false, unique = true)
    private String password;

}
