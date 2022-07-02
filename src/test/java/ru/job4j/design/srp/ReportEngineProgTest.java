package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportEngineProgTest {
    @Test
    public void whenProgGenerated() {
        char dm = (char) 34;
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Ivan", now, now, 90);
        Employee worker3 = new Employee("Ivan", now, now, 80);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        DateFormatter dateFormatter = new ReportDate();
        Report engine = new ReportEngineProg(store, dateFormatter);
        StringBuilder preInformation = new StringBuilder()
                .append("<!DOCTYPE html>")
                .append("<html lang=\"en\">").append(System.lineSeparator())
                .append("<title>......</title>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("<p>").append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;");
        StringBuilder postInformation = new StringBuilder()
                .append("</p>").append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        StringBuilder expect = new StringBuilder()
                .append(preInformation)
                .append(worker1.getName()).append(";")
                .append(dateFormatter.formatDate(worker1.getHired().getTime())).append(";")
                .append(dateFormatter.formatDate(worker1.getFired().getTime())).append(";")
                .append(worker1.getSalary()).append(";")
                .append(worker2.getName()).append(";")
                .append(dateFormatter.formatDate(worker2.getHired().getTime())).append(";")
                .append(dateFormatter.formatDate(worker2.getFired().getTime())).append(";")
                .append(worker2.getSalary()).append(";")
                .append(worker3.getName()).append(";")
                .append(dateFormatter.formatDate(worker3.getHired().getTime())).append(";")
                .append(dateFormatter.formatDate(worker3.getFired().getTime())).append(";")
                .append(worker3.getSalary()).append(";")
                .append(postInformation);
        String gen = engine.generate(em -> true);
        assertThat(gen, is(expect.toString()));
        }

    }

