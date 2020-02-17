package com.example.webfluxdemo.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@RequiredArgsConstructor
@Table("PERSON")
public class Person {
    @Id
   // @Transient for exclude from data base.

    @Column("ID")
    private UUID id;
    @Column("FIRST_NAME")
    private String firstname;
    @Column("LAST_NAME")
    private String lastname;

    public Person(UUID id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Column("AGE")
    private int age;

}
