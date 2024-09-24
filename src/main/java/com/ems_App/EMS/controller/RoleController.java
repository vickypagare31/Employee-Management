package com.ems_App.EMS.controller;

import com.ems_App.EMS.entity.Role;
import com.ems_App.EMS.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping()
    public ResponseEntity<Role> createRole(@RequestBody Role role)
    {
       Role savedRole= roleService.createRole(role);
       return new ResponseEntity<>(savedRole, HttpStatus.OK);
    }

}
