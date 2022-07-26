package ru.job4j.design.srp;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportXmlSerializationTest {

    @Test
    public void json() throws JAXBException, IOException {
        MemStore store = new MemStore();
        ReportDate reportDate = new ReportDate();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan1", now, now, 100);
        Employee worker2 = new Employee("Ivan2", now, now, 90);
        Employee worker3 = new Employee("Ivan3", now, now, 80);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportXmlSerialization(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><employees>")
                .append("<employee name=\"Ivan1\" hired=\"")
                .append(reportDate.formatDate(worker1.getHired().getTime()))
                .append("\" fired=\"")
                .append(reportDate.formatDate(worker1.getFired().getTime()))
                .append("\" salary=\"100.0\"/>")
                .append("<employee name=\"Ivan2\" hired=\"")
                .append(reportDate.formatDate(worker2.getHired().getTime()))
                .append("\" fired=\"")
                .append(reportDate.formatDate(worker2.getFired().getTime()))
                .append("\" salary=\"90.0\"/>")
                .append("<employee name=\"Ivan3\" hired=\"")
                .append(reportDate.formatDate(worker3.getHired().getTime()))
                .append("\" fired=\"")
                .append(reportDate.formatDate(worker3.getFired().getTime()))
                .append("\" salary=\"80.0\"/></employees>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}