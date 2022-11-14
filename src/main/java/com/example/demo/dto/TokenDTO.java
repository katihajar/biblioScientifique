package com.example.demo.dto;

import com.example.demo.document.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TokenDTO {
    private User user;
    private String accessToken;
    private String refreshToken;
}
