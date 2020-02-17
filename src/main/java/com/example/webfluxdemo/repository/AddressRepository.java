package com.example.webfluxdemo.repository;


import com.example.webfluxdemo.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class AddressRepository {
    @Autowired
    DatabaseClient client;
    public   Mono<Void>  createAddressSchema(){
        Mono<Void> completion = client.execute("CREATE TABLE ADDRESS " +
                "(ID VARCHAR(255) PRIMARY KEY, ZIP_CODE VARCHAR(255)," +
                " CITY VARCHAR(255),STREET VARCHAR(255));")
                .then();
        return completion;
    }
    public   Mono<Void>  insertAddress(Address address){
        Mono<Void> completion=  client.execute("INSERT INTO ADDRESS (ID, ZIP_CODE, CITY,STREET) VALUES(:id, :zipCode, :city, :street)")
                .bind("id", address.getId())
                .bind("zipCode",address.getZipCode())
                .bind("city", address.getCity())
                .bind("street", address.getStreet()).then();
        return completion;

    }

}
