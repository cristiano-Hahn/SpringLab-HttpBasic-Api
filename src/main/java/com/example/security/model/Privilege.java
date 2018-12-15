package com.example.security.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}
