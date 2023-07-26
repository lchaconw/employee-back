package com.amaris.employees.service;

import com.amaris.employees.models.Employee;
import com.amaris.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepository.getAll();
        for (Employee employee : employees) {
            double annualSalary = calculateAnnualSalary(employee);
            employee.setAnnualSalary(annualSalary);
        }
        return employees;
    }

    public Employee getEmployeeById(int id) {
        Employee employee = employeeRepository.getById(id);
        double annualSalary = calculateAnnualSalary(employee);
        employee.setAnnualSalary(annualSalary);
        return employee;
    }

    private double calculateAnnualSalary(Employee employee) {
        return employee.getEmployee_salary() * 12;
    }
}
