package com.flywithus.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User", schema = "User")
public class User {
    @Id
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private String nationality;
    @Enumerated(EnumType.STRING)
    private Identification indentification;
    private String indentificationNumber;
    private String email;
    private boolean registered;
}
