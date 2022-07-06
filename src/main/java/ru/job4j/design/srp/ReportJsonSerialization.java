package ru.job4j.design.srp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.function.Predicate;

public class ReportJsonSerialization implements Report {

    private Store store;


    public ReportJsonSerialization(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        ObjectMapper objectMapper = new ObjectMapper();
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        store.findBy(filter).forEach(e -> {
            try {
                text.append(objectMapper.writeValueAsString(e));
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
        });
        return text.toString();
    }
}
