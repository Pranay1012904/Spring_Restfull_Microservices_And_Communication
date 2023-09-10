package com.spring.MicroServices.employeeService.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue){
        super(String.format("%s with %s - %s not found",resourceName,fieldName,fieldValue));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;

    }
    private String resourceName;
    private String fieldName;
    private String fieldValue;

}
