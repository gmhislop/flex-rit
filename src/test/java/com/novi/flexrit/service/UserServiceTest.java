package com.novi.flexrit.service;

import com.novi.flexrit.exception.BadRequestException;
import com.novi.flexrit.model.Role;
import com.novi.flexrit.model.User;
import com.novi.flexrit.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;
    @MockBean
    private RoleService roleService;
    @MockBean
    private UserRepository userRepository;

    @Test
    public void testsave() {
        Role role = new Role();
        User user = new User();
        user.setPassword("password123");
        Mockito.when(roleService.findByName(any())).thenReturn(role);
        Mockito.when(userRepository.save(any())).thenReturn(user);

        User result = userService.save(user);
        Assertions.assertEquals(user, result);
    }

    @Test
    public void testsaveThrowException() {
        Role role = new Role();
        User user = new User();
        user.setPassword("passw");
        Mockito.when(roleService.findByName(any())).thenReturn(role);
        Mockito.when(userRepository.save(any())).thenReturn(user);

        try {
            userService.save(user);
        } catch (BadRequestException e) {
            Assertions.assertEquals("Password length should be between 8 to 15 characters", e.getMessage());
        }
    }

    @Test
    public void testloadUserByUsername() {
        Role role = new Role();
        role.setName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        User user = new User();
        user.setUsername("abc");
        user.setPassword("password");
        user.setRoles(roleSet);
        Mockito.when(userRepository.findByUsername(any())).thenReturn(user);

        UserDetails result = userService.loadUserByUsername("abc");

        Assertions.assertEquals(user.getUsername(), result.getUsername());
        Assertions.assertEquals(user.getPassword(), result.getPassword());

    }
}
