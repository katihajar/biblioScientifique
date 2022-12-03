package com.example.demo.dto;

import com.example.demo.document.Role;
import com.example.demo.document.Universite;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SignupDTO {

    @Id
    private String id;
    @NotBlank
    @Size(min = 3, max = 30)
    private String username;
    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    @NotBlank
    @Size(min = 6, max = 60)
    private String password;
    @NotBlank
    @Size(min = 6, max = 60)
    private String phone;
    @DBRef
    private Universite universite;
    @DBRef
    private Role role;
}
