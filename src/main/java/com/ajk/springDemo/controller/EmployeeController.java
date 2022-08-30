package com.ajk.springDemo.controller;

import com.ajk.springDemo.entity.Employee;
import com.ajk.springDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/hello")
    public String hello(){
        return "Welcome to the Spring!";
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody  Employee emp){
        return employeeService.addEmployee(emp);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employee/{empId}")
    public Employee findEmpById(@PathVariable Long empId){
        return employeeService.findEmpById(empId).get();
    }

    @DeleteMapping("/employee/{empId}")
    public void deleteEmployee(@PathVariable Long empId){
        employeeService.deleteEmployee(empId);

    }

    @PutMapping("/employee/{empId}")
    public Employee updateEmployee(@PathVariable Long empId,
                                   @RequestBody Employee emp){

        return employeeService.updateEmployee(empId, emp);

    }


}
