package com.example.webfluxdemo.repository;

import com.example.webfluxdemo.model.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {

}
