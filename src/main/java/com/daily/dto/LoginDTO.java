package com.daily.dto;

import lombok.Data;

@Data
public class LoginDTO {
    String email;
    String password;
    Integer userType;
}
