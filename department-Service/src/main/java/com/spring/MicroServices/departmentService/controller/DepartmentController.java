package com.spring.MicroServices.departmentService.controller;

import com.spring.MicroServices.departmentService.dto.DepartmentDto;
import com.spring.MicroServices.departmentService.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {
    DepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long id) {
        DepartmentDto fetchedDepartment = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(fetchedDepartment, HttpStatus.FOUND);
    }

    @GetMapping("{dept-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("dept-code") String departmentCode) {
        DepartmentDto fetchedDepartment = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(fetchedDepartment, HttpStatus.FOUND);
    }
}
