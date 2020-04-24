package com.hellocat.springBootAndBootstrap.service;

import com.hellocat.springBootAndBootstrap.domen.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRoles();

    Role findRoleWithName(String roleTypeName);

}
