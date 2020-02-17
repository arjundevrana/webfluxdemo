package com.example.webfluxdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    /*@Autowired
    public AddressRepository  addressRepository;
    @GetMapping("/generate-schema")
    public Mono<Void> createAddressSchema() {
        return addressRepository.createAddressSchema();
    }*/
}
