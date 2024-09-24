package com.ems_App.EMS.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EmployeeDto {

    private Long id;

    private String name;
    private String email;
    private String address;
    private String departmentName;
    private String roleName;
    private String gender;
    private int contact;
    private double salary;

}
