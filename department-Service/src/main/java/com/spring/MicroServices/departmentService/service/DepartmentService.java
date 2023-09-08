package com.spring.MicroServices.departmentService.service;

import com.spring.MicroServices.departmentService.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long id);
    DepartmentDto getDepartmentByCode(String dCode);
}
