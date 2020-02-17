package com.example.webfluxdemo.repository;

import com.example.webfluxdemo.model.Person;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PersonInfoRepository extends ReactiveCrudRepository<Person, UUID> {
    @Query("SELECT * FROM person WHERE lastname = :lastname")
    Flux<Person> findByLastname(String lastname);
    @Query("SELECT firstname, lastname FROM person WHERE lastname = $1")
    Mono<Person> findFirstByLastname(String lastname);
    @Query("UPDATE person SET firstname = :firstname where lastname = :lastname")
    Mono<Integer> setFixedFirstnameFor(String firstname, String lastname);
}
