package com.ems_App.EMS.controller;


import com.ems_App.EMS.Dto.EmployeeDto;
import com.ems_App.EMS.entity.Employee;
import com.ems_App.EMS.service.EmployeeServivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServivce employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
      EmployeeDto createdEmployee= employeeService.createEmployee(employeeDto);
      return new ResponseEntity<>(createdEmployee,HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>>getAllEmployee(EmployeeDto employeeDto)
    {
        List<EmployeeDto> employees= employeeService.getAllEmployee(employeeDto);
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto>getEmployeeById(@PathVariable Long id)
    {
        EmployeeDto employees=employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto>updateEmployeeById(@RequestBody EmployeeDto employeeDto, @PathVariable Long id)
    {
        EmployeeDto updatedEmployee=employeeService.updateEmployeeById(employeeDto,id);
        return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteEmployeeById(@PathVariable Long id)
    {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Employee record deleted successfully", HttpStatus.OK);
    }

}
