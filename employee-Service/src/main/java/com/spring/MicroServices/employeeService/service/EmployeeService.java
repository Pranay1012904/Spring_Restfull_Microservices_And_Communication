package com.spring.MicroServices.employeeService.service;

import com.spring.MicroServices.employeeService.dto.ApiResponseDto;
import com.spring.MicroServices.employeeService.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmp(EmployeeDto employeeDto);
    ApiResponseDto getEmpById(Long id);
}
