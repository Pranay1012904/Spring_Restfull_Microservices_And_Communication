package com.spring.MicroServices.employeeService.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailExistsException extends RuntimeException {
    public EmailExistsException(String email) {
        super(String.format("EMAIL %s exists!",email));
        this.email = email;
    }
    private String email;
}
