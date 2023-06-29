package com.cydeo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@MappedSuperclass //now it can be a parent to entities and all its components will appear in child tables
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;

}
