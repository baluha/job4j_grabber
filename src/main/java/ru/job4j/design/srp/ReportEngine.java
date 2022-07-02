package ru.job4j.design.srp;

import java.text.SimpleDateFormat;
import java.util.function.Predicate;

public class ReportEngine implements Report {

    private Store store;

    private ReportDate reportDate;

    public ReportEngine(Store store, ReportDate reportDate) {
        this.store = store;
        this.reportDate = reportDate;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(reportDate.formatDate(employee.getHired().getTime())).append(";")
                    .append(reportDate.formatDate(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}