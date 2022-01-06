package com.example.demo.controller;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @PostMapping(path = "/getAllStaffs", consumes = "application/json", produces = "application/json")
    public Employees getEmployees() {
        return employeeDao.getAllEmployees();
    }

}