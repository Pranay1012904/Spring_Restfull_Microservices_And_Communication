package com.spring.MicroServices.employeeService.service.impl;

import com.spring.MicroServices.employeeService.dto.ApiResponseDto;
import com.spring.MicroServices.employeeService.dto.DepartmentDto;
import com.spring.MicroServices.employeeService.dto.EmployeeDto;
import com.spring.MicroServices.employeeService.entity.Employee;
import com.spring.MicroServices.employeeService.exception.EmailExistsException;
import com.spring.MicroServices.employeeService.exception.ResourceNotFoundException;
import com.spring.MicroServices.employeeService.mapper.EmployeeMapper;
import com.spring.MicroServices.employeeService.repository.EmployeeRepository;
import com.spring.MicroServices.employeeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    RestTemplate restTemplate;
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
    public ApiResponseDto getEmpById(Long id) {
        Employee fetchedUser=employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("USER","ID",id.toString())
        );
        ResponseEntity<DepartmentDto> responseEntity=restTemplate.getForEntity("http://localhost:8080/api/departments/deptCode/"+fetchedUser.getDepartmentCode(),
                DepartmentDto.class);
        DepartmentDto fetchedDepartment=responseEntity.getBody();
        ApiResponseDto apiResponseDto=new ApiResponseDto(
                EmployeeMapper.entityToDto(fetchedUser),
                fetchedDepartment
        );
        return apiResponseDto;
    }
}
