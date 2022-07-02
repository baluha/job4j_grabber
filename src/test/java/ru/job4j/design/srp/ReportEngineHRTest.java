package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReportEngineHRTest {

    @Test
    public void whenSortGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Ivan", now, now, 90);
        Employee worker3 = new Employee("Ivan", now, now, 80);
        List<Employee> lst = new ArrayList<>();
        lst.add(worker1);
        lst.add(worker2);
        lst.add(worker3);
        store.add(worker2);
        store.add(worker3);
        store.add(worker1);
        Report engine = new ReportEngineHR(store);
        StringBuilder expect = new StringBuilder();
        expect.append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName())
                .append(";")
                .append(worker1.getSalary())
                .append(";")
                .append(System.lineSeparator())
                .append(worker2.getName())
                .append(";")
                .append(worker2.getSalary())
                .append(";")
                .append(System.lineSeparator())
                .append(worker3.getName())
                .append(";")
                .append(worker3.getSalary())
                .append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}