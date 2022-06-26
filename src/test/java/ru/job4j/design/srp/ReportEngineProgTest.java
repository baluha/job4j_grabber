package ru.job4j.design.srp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static ru.job4j.design.srp.ReportEngine.DATE_FORMAT;

public class ReportEngineProgTest {

    @Test
    public void whenProgGenerated() {
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
        Report engine = new ReportEngineProg(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<p>Name; Hired; Fired; Salary;</p>")
                .append(System.lineSeparator());
        for (Employee employee : lst) {
            expect.append("<p>").append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";").append("</p>")
                    .append(System.lineSeparator());
        }
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

}