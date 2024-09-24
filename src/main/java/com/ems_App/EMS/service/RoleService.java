package com.ems_App.EMS.service;


import com.ems_App.EMS.entity.Role;
import com.ems_App.EMS.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getRoleByName(String roleName)
    {
       return roleRepository.findByRoleName(roleName);
    }

    public Role createRole(Role role)
    {
         return roleRepository.save(role);
    }
}
