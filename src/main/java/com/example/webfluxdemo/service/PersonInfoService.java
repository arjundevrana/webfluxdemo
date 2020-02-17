package com.example.webfluxdemo.service;

import com.example.webfluxdemo.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public interface PersonInfoService {
    Mono<Person> save(Person person);
    Mono<Person> getPerson(@PathVariable("id") String id);
    Flux<Person> getAllPersons();
    Mono<Person> updatePerson(@PathVariable("id") String id, @RequestBody Person person);
    Mono<Void> deletePerson(@PathVariable("id") String id);

}
