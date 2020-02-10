package com.example.webfluxdemo.controller;

import com.example.webfluxdemo.model.Person;
import com.example.webfluxdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    public PersonRepository personRepository;
    @GetMapping
    public Flux<Person> findAll() {
        return personRepository.findAll();
    }
}