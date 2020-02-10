package com.example.webfluxdemo.controller;

import com.example.webfluxdemo.model.Person;
import com.example.webfluxdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class CategoryRouter {

    @Autowired
    public PersonRepository personRepository;
    @Bean
    public RouterFunction<ServerResponse> getAllCategoriesRoute() {
        return route(GET("route/person"),
                req -> 
                  ok().body(
                          personRepository.findAll(), Person.class)
                  );
    }
}