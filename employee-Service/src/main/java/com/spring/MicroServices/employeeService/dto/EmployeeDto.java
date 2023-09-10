package com.spring.MicroServices.employeeService.dto;

import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
public class EmployeeDto {
    public EmployeeDto(Long id, String fName, String lName, String email, String departmentCode) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.departmentCode=departmentCode;
    }

    private Long id;
    @NotEmpty(message="First Name Cannot Be Null/Empty")
    private String fName;
    @NotEmpty(message="Last Name Cannot Be Null/Empty")
    private String lName;
    @NotEmpty(message="Email Cannot Be Null/Empty")
    @Email(message="Invalid Email Provided")
    private String email;
    @NotEmpty(message="Department Code can't be Null/Empty")
    String departmentCode;

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

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
