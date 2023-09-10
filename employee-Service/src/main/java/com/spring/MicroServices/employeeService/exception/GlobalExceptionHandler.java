package com.spring.MicroServices.employeeService.exception;

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

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){
        ErrorDetail errorDetail=new ErrorDetail(
                resourceNotFoundException.getMessage(),
                webRequest.getDescription(false),
                LocalDateTime.now(),
                "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetail,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<ErrorDetail> handleEmailExistsException(EmailExistsException emailExistsException, WebRequest webRequest){
        ErrorDetail errorDetail=new ErrorDetail(
                emailExistsException.getMessage(),
                webRequest.getDescription(false),
                LocalDateTime.now(),
                "EMAIL_EXISTS"
        );
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String,String> errorMap=new HashMap<>();
        List<ObjectError> errorList=ex.getBindingResult().getAllErrors();
        errorList.forEach((error)->{
            String field=((FieldError)error).getField();
            String message=error.getDefaultMessage();
            errorMap.put(field,message);
        });
        return new ResponseEntity(errorMap, HttpStatus.BAD_REQUEST);
    }
}
