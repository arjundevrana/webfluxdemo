package com.example.webfluxdemo.controller;

import com.example.webfluxdemo.model.Person;
import com.example.webfluxdemo.service.PersonInfoService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    public @NonNull PersonInfoService personIfoService;
    @PostMapping("/save")
    public Mono<ResponseEntity<Person>> savePersonInfo(@RequestBody Person person) {

        return personIfoService.save(person)
                .map(updatedPerson -> new ResponseEntity<Person>(updatedPerson, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/all")
    public Flux<Person> getAllPersons() {
        return personIfoService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Person>> getPerson(@PathVariable("id") String id) {
        return personIfoService.getPerson(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<Person>> updatePerson(@PathVariable("id") String id, @RequestBody Person person) {
        return personIfoService.updatePerson(id,person)
                .map(updatedPerson -> new ResponseEntity<Person>(updatedPerson, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/remove/{id}")
    public Mono<ResponseEntity<Void>> deletePerson(@PathVariable("id") String id) {
        return personIfoService.deletePerson(id).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)
        ));
    }
}