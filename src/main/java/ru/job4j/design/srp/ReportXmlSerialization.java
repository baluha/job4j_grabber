package ru.job4j.design.srp;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXmlSerialization implements Report {

    private Store store;
    private JAXBContext context;
    private Marshaller marshaller;

    public ReportXmlSerialization(Store store) {
        this.store = store;
        try {
            this.context = JAXBContext.newInstance(Employees.class);
            this.marshaller = context.createMarshaller();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        Employees emp = new Employees(store.findBy(filter));
        try {
            try (StringWriter sw = new StringWriter()) {
                marshaller.marshal(emp, sw);
                text.append(sw.getBuffer().toString());
            }
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
