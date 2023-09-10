package com.spring.MicroServices.employeeService.mapper;

import com.spring.MicroServices.employeeService.dto.EmployeeDto;
import com.spring.MicroServices.employeeService.entity.Employee;

public class EmployeeMapper {

    public static Employee dtoToEntity(EmployeeDto employeeDto){
        Employee employee=new Employee(
                employeeDto.getId(),
                employeeDto.getfName(),
                employeeDto.getlName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        return employee;
    }
    public static EmployeeDto entityToDto(Employee savedEmp){
        EmployeeDto savedEmpDto=new EmployeeDto(
                savedEmp.getId(),
                savedEmp.getFirstName(),
                savedEmp.getLastName(),
                savedEmp.getEmail(),
                savedEmp.getDepartmentCode()
        );
        return savedEmpDto;
    }
}
