package com.springjwt.dto;

import lombok.Data;

@Data
public class SignupDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String role;

}
