package com.imt.part;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "role")
public class RoleEntity {
   @Id
   @Column
   @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
   private Long id;

   @Column
   private String name;
}
