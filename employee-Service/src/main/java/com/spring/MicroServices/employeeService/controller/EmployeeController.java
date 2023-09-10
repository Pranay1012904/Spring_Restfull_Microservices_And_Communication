package com.spring.MicroServices.employeeService.controller;

import com.spring.MicroServices.employeeService.dto.ApiResponseDto;
import com.spring.MicroServices.employeeService.dto.EmployeeDto;
import com.spring.MicroServices.employeeService.exception.EmailExistsException;
import com.spring.MicroServices.employeeService.exception.ErrorDetail;
import com.spring.MicroServices.employeeService.exception.ResourceNotFoundException;
import com.spring.MicroServices.employeeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;
    @PostMapping("/api/create")
    public ResponseEntity<EmployeeDto> createEmp(@RequestBody @Valid EmployeeDto employeeDto){
        EmployeeDto savedEmp=employeeService.createEmp(employeeDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @GetMapping("/api/id/{id}")
    public ResponseEntity<ApiResponseDto> getEmpById(@PathVariable Long id){
            ApiResponseDto fetchedEmp=employeeService.getEmpById(id);
        return new ResponseEntity<>(fetchedEmp, HttpStatus.FOUND);
    }

}
