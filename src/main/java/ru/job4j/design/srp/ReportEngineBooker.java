package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportEngineBooker implements Report {

    private ReportDate reportDate;

    private static final int RUB = 100;

    private Store store;

    public ReportEngineBooker(Store store, ReportDate reportDate) {
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
                    .append(employee.getSalary() * RUB).append(" rub").append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
