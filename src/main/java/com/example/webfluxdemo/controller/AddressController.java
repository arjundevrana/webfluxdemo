package com.example.webfluxdemo.controller;

import com.example.webfluxdemo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    public AddressRepository  addressRepository;
        @GetMapping("/generate-schema")
    public Mono<Void> createAddressSchema() {
        return addressRepository.createAddressSchema();
    }
}
