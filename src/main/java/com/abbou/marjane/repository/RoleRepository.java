package com.abbou.marjane.repository;

import com.abbou.marjane.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String userRole);
}
