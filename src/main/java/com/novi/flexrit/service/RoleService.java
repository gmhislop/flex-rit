package com.novi.flexrit.service;

import com.novi.flexrit.model.Role;
import com.novi.flexrit.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role findByName(String name) {
        Role role = roleDao.findRoleByName(name);
        return role;
    }
}