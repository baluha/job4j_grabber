package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static ru.job4j.design.srp.ReportEngine.DATE_FORMAT;

import org.junit.Test;
import ru.job4j.design.srp.Employee;
import ru.job4j.design.srp.MemStore;
import ru.job4j.design.srp.Report;
import ru.job4j.design.srp.ReportEngine;

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
                .append(System.lineSeparator());
        for (Employee employee : lst) {
            expect.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}