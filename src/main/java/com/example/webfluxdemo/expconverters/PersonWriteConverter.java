package com.example.webfluxdemo.expconverters;

import com.example.webfluxdemo.model.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import org.springframework.data.r2dbc.mapping.SettableValue;

@WritingConverter
public class PersonWriteConverter implements Converter<Person, OutboundRow> {

    public OutboundRow convert(Person source) {
        OutboundRow row = new OutboundRow();
        row.put("id", SettableValue.from(source.getId()));
        row.put("firstname", SettableValue.from(source.getFirstname()));
        row.put("age", SettableValue.from(source.getAge()));
        return row;
    }
}