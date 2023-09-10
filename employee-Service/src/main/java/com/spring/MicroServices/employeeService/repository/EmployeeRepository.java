package com.spring.MicroServices.employeeService.repository;

import com.spring.MicroServices.employeeService.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
