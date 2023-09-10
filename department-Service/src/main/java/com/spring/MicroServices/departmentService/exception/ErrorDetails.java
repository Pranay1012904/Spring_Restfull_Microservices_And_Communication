package com.spring.MicroServices.departmentService.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class ErrorDetails {
    public ErrorDetails(LocalDateTime timeStamp, String message, String description, String errorCode) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.description = description;
        this.errorCode = errorCode;
    }
    private LocalDateTime timeStamp;
    private String message;
    private String description;
    private String errorCode;
}
