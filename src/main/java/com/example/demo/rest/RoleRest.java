package com.example.demo.rest;

import com.example.demo.document.Role;
import com.example.demo.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/role")
public class RoleRest {
    @Autowired
    RoleRepo roleRepo;

    @GetMapping("/")
    public List<Role> findAll() {
        return roleRepo.findAll();
    }
}
