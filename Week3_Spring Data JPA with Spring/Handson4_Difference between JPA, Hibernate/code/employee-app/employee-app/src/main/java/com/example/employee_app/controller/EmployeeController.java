package com.example.employee_app.controller;

import com.example.employee_app.model.Employee;
import com.example.employee_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return "Employee saved successfully!";
    }
    @GetMapping("/test")
    public String test() {
        return "Test working!";
    }

}

