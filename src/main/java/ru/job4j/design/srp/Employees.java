package ru.job4j.design.srp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {

        @XmlElement(name = "employee")
        private List<Employee> emp;
        public Employees() {

        }

        public Employees(List<Employee> emp) {
            this.emp = emp;
        }

        public List<Employee> getEmp() {
            return emp;
        }

        public void setEmp(List<Employee> emp) {
            this.emp = emp;
        }
}
