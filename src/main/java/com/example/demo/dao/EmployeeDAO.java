package com.example.demo.dao;

import com.example.demo.model.Employees;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

    private static Employees list = new Employees();

    static {
        list.getEmployeeList().add(new Employee(1, "Mahsa", "Saeedi", "mahsa.saeedy@google.com"));
        list.getEmployeeList().add(new Employee(2, "Sam", "Imani", "sam.imani@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "Mitra", "Lohrasbi", "m.lohrasbi@gmail.com"));
        list.getEmployeeList().add(new Employee(4, "Mina", "Dadgar", "mina.dadgar@gmail.com"));
        list.getEmployeeList().add(new Employee(5, "Elham", "Heydari", "elham.heydari@gmail.com"));
        list.getEmployeeList().add(new Employee(6, "Leila", "Kazemi", "Leila.kazemi@gmail.com"));
        list.getEmployeeList().add(new Employee(7, "Nasrin", "Dindar", "nasrin.dindar@gmail.com"));
        list.getEmployeeList().add(new Employee(8, "Farkhonde", "Ghazi", "f.ghazi@gmail.com"));
        list.getEmployeeList().add(new Employee(9, "Aboozar", "Rajabi", "ab.rajabi@gmail.com"));
        list.getEmployeeList().add(new Employee(10, "Mahdi", "Saeedi", "m.saeedy@gmail.com"));
        list.getEmployeeList().add(new Employee(11, "Mohsen", "Saeedi", "m.hosseini@gmail.com"));
        list.getEmployeeList().add(new Employee(12, "Behnaz", "Motavali", "behnaz.motavali@gmail.com"));
        list.getEmployeeList().add(new Employee(13, "Zahra", "Taghizaeh", "zara.taghiZade@gmail.com"));
    }

    public Employees getAllEmployees() {
        return list;
    }
}