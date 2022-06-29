package ru.job4j.design.srp;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class ReportEngineProg implements Report {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    private DateFormatter dateFormatter;

    private Store store;

    public ReportEngineProg(Store store, DateFormatter dateFormatter) {
        this.store = store;
        this.dateFormatter = dateFormatter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        char dm = (char) 34;
        StringBuilder preInformation = new StringBuilder();
        StringBuilder postInformation = new StringBuilder();
        preInformation.append("<!DOCTYPE html>")
                .append("<html lang=").append(dm).append("en").append(dm).append(">").append(System.lineSeparator())
                .append("\\t<title>......</title>").append(System.lineSeparator())
                .append("\\t\\t<body>").append(System.lineSeparator())
                .append("\\t\\t\\t<p>").append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;");
        postInformation.append("\\t\\t\\t</p>").append(System.lineSeparator())
                .append("\\t\\t</body>").append(System.lineSeparator())
                .append("</html>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(dateFormatter.formatDate(employee.getHired().getTime())).append(";")
                    .append(dateFormatter.formatDate(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return preInformation.append(text).append(postInformation).toString();
    }
}
