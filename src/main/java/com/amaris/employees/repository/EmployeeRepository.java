package com.amaris.employees.repository;

import com.amaris.employees.models.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ApiRepository<Employee> {

}
