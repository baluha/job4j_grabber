package ru.job4j.design.srp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static ru.job4j.design.srp.ReportEngine.DATE_FORMAT;

public class ReportEngineBookerTest {
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
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportEngineBooker(store);
        StringBuilder expect = new StringBuilder();
        expect.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : lst) {
                    expect.append(employee.getName()).append(";")
                            .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                            .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                            .append(employee.getSalary() * 100).append(" rub").append(";")
                            .append(System.lineSeparator());
        }
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}