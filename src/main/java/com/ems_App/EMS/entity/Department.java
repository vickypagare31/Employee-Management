package com.ems_App.EMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    private String departmentName;

   @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
