package com.novi.flexrit.service;

import com.novi.flexrit.exception.BadRequestException;
import com.novi.flexrit.exception.InvalidPasswordException;
import com.novi.flexrit.model.Role;
import com.novi.flexrit.model.User;
import com.novi.flexrit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepository userRepository;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    public User findOne(String username) {
        return userRepository.findByUsername(username);
    }


    public User save(User user) {
        // this is used for creating a bcryptEncoder object, and then
        // we call encode method on that by passing password
        User byUsername = userRepository.findByUsername(user.getUsername());
        if(byUsername != null) {
            throw  new BadRequestException("username is already taken");
        }

        if ((user.getPassword().length() < 8)
                || (user.getPassword().length() >= 15)) {
            throw new InvalidPasswordException("Password length should be between 8 to 15 characters");
        }

        BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
        String password = user.getPassword();
        String encodePassword = bcryptEncoder.encode(password);
        user.setPassword(encodePassword);

        Role role = roleService.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        user.setRoles(roleSet);
        return userRepository.save(user);
    }
}