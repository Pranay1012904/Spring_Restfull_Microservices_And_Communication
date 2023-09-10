package com.spring.MicroServices.employeeService.service.impl;

import com.spring.MicroServices.employeeService.dto.EmployeeDto;
import com.spring.MicroServices.employeeService.entity.Employee;
import com.spring.MicroServices.employeeService.exception.EmailExistsException;
import com.spring.MicroServices.employeeService.exception.ResourceNotFoundException;
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
        Optional<Employee> verifyEmail=employeeRepository.findByEmail(employeeDto.getEmail());
        if(verifyEmail.isPresent()) {
            throw new EmailExistsException(employeeDto.getEmail());
        }
        Employee employee= EmployeeMapper.dtoToEntity(employeeDto);
        Employee savedEmp=employeeRepository.save(employee);
        EmployeeDto savedEmpDto=EmployeeMapper.entityToDto(savedEmp);
        return savedEmpDto;
    }

    @Override
    public EmployeeDto getEmpById(Long id) {
        Employee fetchedUser=employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("USER","ID",id.toString())
        );
        return EmployeeMapper.entityToDto(fetchedUser);
    }
}
