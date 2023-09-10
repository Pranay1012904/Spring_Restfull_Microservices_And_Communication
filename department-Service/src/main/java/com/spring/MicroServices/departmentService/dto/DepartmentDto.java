package com.spring.MicroServices.departmentService.dto;

import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
public class DepartmentDto {
    public DepartmentDto(Long id, String departmentName, String departmentDescription, String departmentCode) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.departmentCode = departmentCode;
    }

    private Long id;
    @NotEmpty(message="Department name cannot be null/empty.")
    private String departmentName;
    @NotEmpty(message="Department Description cannot be null/empty.")
    private String departmentDescription;
    @NotEmpty(message="Department Code cannot be null/empty.")
    private String departmentCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
