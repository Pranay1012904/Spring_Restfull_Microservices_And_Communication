package com.spring.MicroServices.employeeService.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ErrorDetail {
    public ErrorDetail(String message, String description, LocalDateTime timeStamp, String errorCode) {
        this.message = message;
        this.description = description;
        this.timeStamp=timeStamp;
        this.errorCode = errorCode;
    }

    private String message;
    private String description;
    private LocalDateTime timeStamp;
    private String errorCode;
}
