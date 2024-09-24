package com.ems_App.EMS.controller;

import com.ems_App.EMS.entity.Department;
import com.ems_App.EMS.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping()
    public ResponseEntity<Department>createDepartment(@RequestBody Department department)
    {
        Department savedDepartment= departmentService.createDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
    }


}
