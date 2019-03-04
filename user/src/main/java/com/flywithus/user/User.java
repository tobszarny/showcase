package com.flywithus.user;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class User {
    private String firstName;
    private String middleName;
    private String lastName;
    private String username;
    private LocalDate birthDate;
    private String nationality;
    private Identification indentification;
    private String indentificationNumber;
    private String email;
    private boolean registered;
}
