package com.spring.MicroServices.employeeService.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmployeeDto {
    public EmployeeDto(Long id, String fName, String lName, String email) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    private Long id;
    private String fName;
    private String lName;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
