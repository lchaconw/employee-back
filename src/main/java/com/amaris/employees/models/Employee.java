package com.amaris.employees.models;

import lombok.Data;

@Data
public class Employee {
    private long id;
    private String employee_name;
    private double employee_salary;
    private double annualSalary;
    private int employee_age;
    private String profile_image;
}
