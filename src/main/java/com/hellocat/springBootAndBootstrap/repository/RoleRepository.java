package com.hellocat.springBootAndBootstrap.repository;

import com.hellocat.springBootAndBootstrap.domen.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getRoleByRoleType(String roleType);

}
