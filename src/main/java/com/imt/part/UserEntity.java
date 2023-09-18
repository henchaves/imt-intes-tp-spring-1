package com.imt.part;

import javax.persistence.*;

@Entity(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String login;

    @Column
    private String password;

    @OneToOne
    private RoleEntity role;
}
