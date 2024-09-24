package com.ems_App.EMS.repository;

import com.ems_App.EMS.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employee,Long> {

}
