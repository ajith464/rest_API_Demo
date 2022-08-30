package com.ajk.springDemo.service;

import com.ajk.springDemo.entity.Employee;
import com.ajk.springDemo.repository.EmployeeRepo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo empRepo;
    @Override
    public Employee addEmployee(Employee emp) {
        return empRepo.save(emp);
    }
    public Optional<Employee> findEmpById(Long id) {
        return empRepo.findById(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return empRepo.findAll();
    }

    @Override
    public void deleteEmployee(Long empId) {
        empRepo.deleteById(empId);
    }

    @Override
    public Employee updateEmployee(Long empId, Employee emp) {

        Employee dbEmp = empRepo.findById(empId).get();

        if(StringUtils.isNotBlank(emp.getDepartmentId())
                && !StringUtils.equalsIgnoreCase(emp.getDepartmentId(), dbEmp.getDepartmentId()))
            dbEmp.setDepartmentId(emp.getDepartmentId());

        if(StringUtils.isNotBlank(emp.getFirstName())
                && !StringUtils.equalsIgnoreCase(emp.getFirstName(), dbEmp.getFirstName()))
            dbEmp.setFirstName(emp.getFirstName());

        if(StringUtils.isNotBlank(emp.getLastName())
                && !StringUtils.equalsIgnoreCase(emp.getLastName(), dbEmp.getLastName()))
            dbEmp.setLastName(emp.getLastName());

        if(Objects.nonNull(emp.getSalary()) &&
                emp.getSalary() != dbEmp.getSalary())
            dbEmp.setSalary(emp.getSalary());

         return  empRepo.save(dbEmp);
    }
}
