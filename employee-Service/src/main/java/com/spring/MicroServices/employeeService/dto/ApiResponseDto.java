package com.spring.MicroServices.employeeService.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ApiResponseDto {
    public ApiResponseDto(EmployeeDto employeeDto, DepartmentDto departmentDto) {
        this.employeeDto = employeeDto;
        this.departmentDto = departmentDto;
    }

    private EmployeeDto employeeDto;
    private  DepartmentDto departmentDto;

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
    }
}
