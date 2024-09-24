package com.ems_App.EMS.repository;

import com.ems_App.EMS.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(String roleName);
}
