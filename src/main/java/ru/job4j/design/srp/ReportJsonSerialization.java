package ru.job4j.design.srp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.function.Predicate;

public class ReportJsonSerialization implements Report {

    private Store store;
    private ObjectMapper objectMapper;

    public ReportJsonSerialization(Store store) {
        this.objectMapper = new ObjectMapper();
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JsonProcessingException {
        StringBuilder text = new StringBuilder();
        text.append(objectMapper.writeValueAsString(store.findBy(filter)));
        return text.toString();
    }
}
