package com.yasar.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get, set, toString
@AllArgsConstructor // parametreli constructorların tümü
@NoArgsConstructor // default constructor
@Builder
public class LoginRequestDto {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
