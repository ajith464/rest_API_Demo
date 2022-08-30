package com.ajk.springDemo.service;

import com.ajk.springDemo.entity.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    public Employee addEmployee(Employee emp);

    Optional<Employee> findEmpById(Long empId);

    List<Employee> findAllEmployees();

    void deleteEmployee(Long empId);

    Employee updateEmployee(Long empId, Employee emp);
}
