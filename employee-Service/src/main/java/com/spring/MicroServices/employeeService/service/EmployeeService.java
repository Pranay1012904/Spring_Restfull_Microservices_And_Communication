package com.spring.MicroServices.employeeService.service;

import com.spring.MicroServices.employeeService.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmp(EmployeeDto employeeDto);
    EmployeeDto getEmpById(Long id);
}
