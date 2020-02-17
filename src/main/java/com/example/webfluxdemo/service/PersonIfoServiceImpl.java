package com.example.webfluxdemo.service;

import com.example.webfluxdemo.model.Person;
import com.example.webfluxdemo.repository.PersonInfoRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class PersonIfoServiceImpl implements PersonInfoService {
    @Autowired
    public @NonNull PersonInfoRepository personInfoRepository;
    @Transactional
    @Override
    public Mono<Person> save(Person person) {
        return personInfoRepository.save(person);
    }

    @Override
    public Mono<Person> getPerson(String id) {
        UUID uuid = UUID.fromString(id);
        return personInfoRepository.findById(uuid);
    }

    @Override
    public Flux<Person> getAllPersons() {
        return personInfoRepository.findAll();
    }

    @Override
    public Mono<Person> updatePerson(String id, Person person) {
        UUID uuid = UUID.fromString(id);
        return personInfoRepository.findById(uuid).flatMap(currentPerson -> {
            currentPerson.setFirstname(person.getFirstname());
            currentPerson.setLastname(person.getLastname());
            currentPerson.setAge(person.getAge());
            return personInfoRepository.save(currentPerson);
        });
    }

    @Override
    public Mono<Void> deletePerson(String id) {
        UUID uuid = UUID.fromString(id);
        return personInfoRepository.deleteById(uuid);
    }
}
