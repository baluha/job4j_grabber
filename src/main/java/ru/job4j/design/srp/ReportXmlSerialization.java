package ru.job4j.design.srp;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportXmlSerialization implements Report {

    private Store store;

    public ReportXmlSerialization(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException, IOException {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            store.findBy(filter).forEach(v -> {
                try {
                    marshaller.marshal(v, writer);
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
            });

            text.append(writer.getBuffer().toString());
        }

        return text.toString();
    }
}
