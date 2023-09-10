package com.spring.MicroServices.departmentService.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DepartmentExistsException.class)
    public ResponseEntity<ErrorDetails> handleDepartmentExistsException(DepartmentExistsException departmentExistsException,WebRequest webRequest){
            ErrorDetails errorDetails=new ErrorDetails(
                    LocalDateTime.now(),
                    departmentExistsException.getMessage(),
                    webRequest.getDescription(false),
                    "DEPARTMENT_CODE_EXISTS"
            );
            return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String,String> errorMap=new HashMap<>();
        List<ObjectError> errorList= ex.getBindingResult().getAllErrors();
        errorList.forEach(error->{
            String field=((FieldError)error).getField();
            String value=error.getDefaultMessage();
            errorMap.put(field,value);
        });
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
