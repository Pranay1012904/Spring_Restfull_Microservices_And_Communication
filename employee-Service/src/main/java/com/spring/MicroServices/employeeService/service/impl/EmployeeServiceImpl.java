package com.spring.MicroServices.employeeService.service.impl;

import com.spring.MicroServices.employeeService.dto.EmployeeDto;
import com.spring.MicroServices.employeeService.entity.Employee;
import com.spring.MicroServices.employeeService.mapper.EmployeeMapper;
import com.spring.MicroServices.employeeService.repository.EmployeeRepository;
import com.spring.MicroServices.employeeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmp(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.dtoToEntity(employeeDto);
        Employee savedEmp=employeeRepository.save(employee);
        EmployeeDto savedEmpDto=EmployeeMapper.entityToDto(savedEmp);
        return savedEmpDto;
    }

    @Override
    public EmployeeDto getEmpById(Long id) {
        Optional<Employee> fetchedUser=employeeRepository.findById(id);
        return EmployeeMapper.entityToDto(fetchedUser.get());
    }
}
