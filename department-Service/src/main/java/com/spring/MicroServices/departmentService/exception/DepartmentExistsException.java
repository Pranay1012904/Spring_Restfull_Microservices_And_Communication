package com.spring.MicroServices.departmentService.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepartmentExistsException extends RuntimeException{
    public DepartmentExistsException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s with %s : %s already exists!",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    private String resourceName;
    private String fieldName;
    private String fieldValue;
}
