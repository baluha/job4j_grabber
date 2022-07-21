package ru.job4j.design.srp;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXmlSerialization implements Report {

    private Store store;

    JAXBContext context = JAXBContext.newInstance(Employees.class);
    Marshaller marshaller = context.createMarshaller();

    public ReportXmlSerialization(Store store) throws JAXBException {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException, IOException {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        Employees emp = new Employees(store.findBy(filter));
        try (StringWriter sw = new StringWriter()) {
            marshaller.marshal(emp, sw);
            text.append(sw.getBuffer().toString());
        }
        return text.toString();
    }
}
