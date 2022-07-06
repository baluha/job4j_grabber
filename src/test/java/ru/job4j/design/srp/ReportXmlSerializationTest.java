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
        expect.append("Name; Hired; Fired; Salary;"
                + "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                        + "<employee name=\"Ivan1\" hired=\"" + reportDate.formatDate(worker1.getHired().getTime())
                + "\" fired=\"" + reportDate.formatDate(worker1.getFired().getTime()) + "\" salary=\"100.0\"/>"
                        + "\n<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                        + "<employee name=\"Ivan2\" hired=\"" + reportDate.formatDate(worker2.getHired().getTime())
                + "\" fired=\"" + reportDate.formatDate(worker2.getFired().getTime()) + "\" salary=\"90.0\"/>"
                        + "\n<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                        + "<employee name=\"Ivan3\" hired=\"" + reportDate.formatDate(worker3.getHired().getTime())
                + "\" fired=\"" + reportDate.formatDate(worker3.getFired().getTime()) + "\" salary=\"80.0\"/>\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}