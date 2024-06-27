package com.yasar.dto.request;

import com.yasar.validation.UniqueEmail;
import com.yasar.validation.UniqueUserName;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get, set, toString
@AllArgsConstructor // parametreli constructorların tümü
@NoArgsConstructor // default constructor
@Builder
public class RegisterRequestDto {
    @Email
    @UniqueEmail
    private String email;

    @NotBlank(message = "Kullanıcı adı boş geçilemez.")
    @Size(min = 3, max = 32, message = "Kullanıcı adı uzunluğu minimum 3, maksimum 32 karakter olmalıdır.")
    @UniqueUserName
    private String userName;

    @NotBlank(message = "Şifre boş geçilemez.")
    @Size(min = 8, max = 32, message = "Şifre uzunluğu minimum 8, maksimum 32 karakter olmalıdır.")
    //@Pattern(regexp = "^.*(?=.{5,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
    private String password;
}
