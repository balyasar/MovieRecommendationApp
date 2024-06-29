package com.yasar.dto.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data // get, set, toString
@AllArgsConstructor // parametreli constructorların tümü
@NoArgsConstructor // default constructor
@Builder
public class UserProfileUpdateRequestDto {
    private String token;
    private String userName;
    @Email
    private String email;
    private String name;
    private String surName;
    private String phone;
    private String address;
    private String avatar;
    private String about;
    private LocalDate birthDate;
}
