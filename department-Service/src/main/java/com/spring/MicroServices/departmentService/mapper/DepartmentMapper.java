package com.spring.MicroServices.departmentService.mapper;

import com.spring.MicroServices.departmentService.dto.DepartmentDto;
import com.spring.MicroServices.departmentService.entity.Department;

public class DepartmentMapper {

    public static Department dtoToEntity(DepartmentDto departmentDto){
        Department department=new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        return department;
    }

    public static DepartmentDto entityToDto(Department savedDepartment){
        DepartmentDto savedDepartmentDto=new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );
        return savedDepartmentDto;
    }
}
