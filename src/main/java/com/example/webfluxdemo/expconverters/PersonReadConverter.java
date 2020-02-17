package com.example.webfluxdemo.expconverters;

import com.example.webfluxdemo.model.Person;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.util.UUID;

@ReadingConverter
public class PersonReadConverter implements Converter<Row, Person> {
    @Override
    public Person convert(Row source) {
        Person p = new Person(source.get("id", UUID.class),source.get("firstname", String.class),source.get("lastname", String.class));
        p.setAge(source.get("age", Integer.class));
        return p;
    }
}
