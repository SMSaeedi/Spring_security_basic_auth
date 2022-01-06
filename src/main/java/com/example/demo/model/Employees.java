package com.example.demo.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Employees {

    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }
}
