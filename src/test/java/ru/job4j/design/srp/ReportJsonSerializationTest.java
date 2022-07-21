package ru.job4j.design.srp;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportJsonSerializationTest {

    @Test
    public void json() throws JAXBException, IOException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Ivan", now, now, 90);
        Employee worker3 = new Employee("Ivan", now, now, 80);
        store.add(worker2);
        store.add(worker3);
        store.add(worker1);
        Report engine = new ReportJsonSerialization(store);
        StringBuilder expect = new StringBuilder();
        expect.append("Name; Hired; Fired; Salary;")
                .append("{\"name\":\"Ivan\",\"hired\":")
                .append(worker1.getHired().getTimeInMillis())
                .append(",").append("\"fired\":")
                .append(worker1.getFired().getTimeInMillis())
                .append(",").append("\"salary\":90.0}")
                .append("{\"name\":\"Ivan\",\"hired\":")
                .append(worker2.getHired().getTimeInMillis())
                .append(",").append("\"fired\":")
                .append(worker2.getHired().getTimeInMillis())
                .append(",").append("\"salary\":80.0}")
                .append("{\"name\":\"Ivan\",\"hired\":")
                .append(worker3.getHired().getTimeInMillis())
                .append(",").append("\"fired\":")
                .append(worker3.getHired().getTimeInMillis())
                .append(",").append("\"salary\":100.0}");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}