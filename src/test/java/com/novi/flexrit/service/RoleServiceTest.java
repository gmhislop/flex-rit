package com.novi.flexrit.service;

import com.novi.flexrit.model.Role;
import com.novi.flexrit.repository.RoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class RoleServiceTest {

    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    @Test
    public void testFindByName() {
        Role role = new Role();
        Mockito.when(roleRepository.findRoleByName(any())).thenReturn(role);
        Role result = roleService.findByName("USER");
        Assertions.assertEquals(role, result);
    }
}
