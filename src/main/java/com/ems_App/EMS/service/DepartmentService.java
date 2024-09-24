package com.ems_App.EMS.service;

import com.ems_App.EMS.entity.Department;
import com.ems_App.EMS.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department getDepartmentByName(String departmentName)
    {
        Department department=departmentRepository.findByDepartmentName(departmentName);
        return department;
    }

    public Department createDepartment(Department department)
    {
        return departmentRepository.save(department);
    }
}
