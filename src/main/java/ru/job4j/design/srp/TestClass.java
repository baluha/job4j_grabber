package ru.job4j.design.srp;

import java.util.Calendar;

public class TestClass {
    public static void main(String[] args) {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        char dm = (char) 34;
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Ivan", now, now, 90);
        Employee worker3 = new Employee("Ivan", now, now, 80);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        DateFormatter dateFormatter = new ReportDate();
        Report engine = new ReportEngineProg(store, dateFormatter);
        StringBuilder exp = new StringBuilder();
        exp.append("<html lang=").append("\\").append(dm).append("en\\").append(dm).append(">").append("\\r\\n")
                .append("<title>......</title>").append("\\r\\n")
                .append("<body>").append("\\r\\n").append("<p>").append("\\r\\n")
                .append("Name; Hired; Fired; Salary;").append("Ivan;").append(dateFormatter.formatDate(worker1.getFired().getTime()))
                .append(";")
                .append(dateFormatter.formatDate(worker1.getHired().getTime())).append(";").append(worker1.getSalary()).append(";")
                .append("Ivan;").append(dateFormatter.formatDate(worker2.getFired().getTime())).append(";")
                .append(dateFormatter.formatDate(worker2.getHired().getTime())).append(";").append(worker2.getSalary()).append(";")
                .append("Ivan;").append(dateFormatter.formatDate(worker3.getFired().getTime())).append(";")
                .append(dateFormatter.formatDate(worker3.getHired().getTime())).append(";").append(worker3.getSalary()).append(";")
                .append("</p>\\r\\n")
                .append("</body>").append("\\r\\n")
                .append("</html>").append("\\r\\n");
        System.out.println(exp);
    }
}
