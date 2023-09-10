package com.spring.MicroServices.departmentService.service.impl;

import com.spring.MicroServices.departmentService.dto.DepartmentDto;
import com.spring.MicroServices.departmentService.entity.Department;
import com.spring.MicroServices.departmentService.exception.DepartmentExistsException;
import com.spring.MicroServices.departmentService.mapper.DepartmentMapper;
import com.spring.MicroServices.departmentService.repository.DepartmentRepository;
import com.spring.MicroServices.departmentService.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
       Optional<Department> dept=departmentRepository.findDepartmentBydepartmentCode(departmentDto.getDepartmentCode());
       if(dept.isPresent()){
           throw new DepartmentExistsException("Department","DepartmentCode",departmentDto.getDepartmentCode());
       }
       //convert DTO to Entity
        Department department= DepartmentMapper.dtoToEntity(departmentDto);
        Department savedDepartment=departmentRepository.save(department);
        //entity to DTO
        DepartmentDto savedDepartmentDto=DepartmentMapper.entityToDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Optional<Department> fetchedDepartment=departmentRepository.findById(id);
        return DepartmentMapper.entityToDto(fetchedDepartment.get());
    }

    @Override
    public DepartmentDto getDepartmentByCode(String dCode) {
        Optional<Department> fetchedDepartment=departmentRepository.findDepartmentBydepartmentCode(dCode);
        return DepartmentMapper.entityToDto(fetchedDepartment.get());
    }
}
