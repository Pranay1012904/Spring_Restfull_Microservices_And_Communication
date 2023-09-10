package com.spring.MicroServices.employeeService.controller;

import com.spring.MicroServices.employeeService.dto.EmployeeDto;
import com.spring.MicroServices.employeeService.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;
    @PostMapping("/api/create")
    public ResponseEntity<EmployeeDto> createEmp(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmp=employeeService.createEmp(employeeDto);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @GetMapping("/api/id/{id}")
    public ResponseEntity<EmployeeDto> getEmpById(@PathVariable Long id){
            EmployeeDto fetchedEmp=employeeService.getEmpById(id);
        return new ResponseEntity<>(fetchedEmp, HttpStatus.FOUND);
    }
}