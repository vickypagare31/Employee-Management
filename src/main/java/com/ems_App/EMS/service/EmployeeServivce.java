package com.ems_App.EMS.service;

import com.ems_App.EMS.Dto.EmployeeDto;
import com.ems_App.EMS.entity.Department;
import com.ems_App.EMS.entity.Employee;
import com.ems_App.EMS.entity.Role;
import com.ems_App.EMS.repository.DepartmentRepository;
import com.ems_App.EMS.repository.EmployeRepository;
import com.ems_App.EMS.repository.RoleRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServivce {

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private RoleService roleService;

    //Convert DTO to Entity
    //Create new Employee
    public EmployeeDto createEmployee(EmployeeDto employeeDto)
    {
        Department department=departmentRepository.findByDepartmentName(employeeDto.getDepartmentName());
        Role role=roleRepository.findByRoleName(employeeDto.getRoleName());

        Employee employee=new Employee();
        employee.setName(employeeDto.getName());
        employee.setAddress(employeeDto.getAddress());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartment(department);
        employee.setRole(role);
        employee.setContact(employeeDto.getContact());
        employee.setGender(employeeDto.getGender());
        employee.setSalary(employeeDto.getSalary());

        Employee savedEmployee=employeRepository.save(employee);
        return mapToDTO(savedEmployee);
    }

    //Convert Entity to DTO
    private EmployeeDto mapToDTO(Employee employee) {

        EmployeeDto dto=new EmployeeDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setAddress(employee.getAddress());
        dto.setDepartmentName(employee.getDepartment().getDepartmentName());
        dto.setRoleName(employee.getRole().getRoleName());
        dto.setGender(employee.getGender());
        dto.setContact(employee.getContact());
        dto.setSalary(employee.getSalary());

        return dto;

        }

        //Get All employees
        public List<EmployeeDto>getAllEmployee(EmployeeDto employeeDto)
        {
            List<Employee> employees=employeRepository.findAll();

            //Converting Employee Entity to Employee Dto objects
            return employees.stream().map(this::mapToDTO).collect(Collectors.toList());
        }

        //Get Employees by ID
        public EmployeeDto getEmployeeById(Long id)
        {
            Employee employee=employeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));
            return mapToDTO(employee);
        }

        //Update Employee
        public EmployeeDto updateEmployeeById(EmployeeDto employeeDto, Long id)
        {
            Employee employee=employeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
            employee.setName(employeeDto.getName());
            employee.setEmail(employeeDto.getEmail());
            employee.setAddress(employeeDto.getAddress());
            employee.setDepartment(departmentRepository.findByDepartmentName(employeeDto.getDepartmentName()));
            employee.setRole(roleRepository.findByRoleName(employeeDto.getRoleName()));
            employee.setContact(employeeDto.getContact());
            employee.setGender(employeeDto.getGender());
            employee.setSalary(employeeDto.getSalary());
            Employee updatedEmployee=employeRepository.save(employee);
            return mapToDTO(updatedEmployee);
        }

        //Delete Employee by Id
        public void deleteEmployeeById(Long id)
        {
            Employee employee=employeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
            employeRepository.deleteById(id);
        }


    }

