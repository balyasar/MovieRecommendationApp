package com.yasar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorType {
    BAD_REQUEST_ERROR(4100, "Girilen bilgiler eksik ya da hatalıdır.", HttpStatus.BAD_REQUEST),
    BAD_REQUEST_REPASSWORD_ERROR(4110, "Girilen şifreler uyuşmuyor.", HttpStatus.BAD_REQUEST),
    BAD_REQUEST_USERNAME_OR_PASSWORD_ERROR(4120, "Kullanıcı adı ya da şifre hatalıdır..", HttpStatus.BAD_REQUEST),
    USERNAME_ALREADY_EXIST(4130, "Kullanıcı adı zaten mevcut", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4140, "Kullanıcı bulunamadı.", HttpStatus.NOT_FOUND),
    USER_ALREADY_ACTIVE(4150, "Kullanıcı zaten aktif durumdadır", HttpStatus.BAD_REQUEST),
    INVALID_ACTIVATION_CODE(4160, "Geçersiz aktivasyon kodu", HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(4170, "Geçersiz token", HttpStatus.BAD_REQUEST),
    TOKEN_NOT_CREATED(4180, "Token yaratılamadı", HttpStatus.BAD_REQUEST),
    ACCOUNT_NOT_ACTIVE(4190, "Hesap aktif değil.", HttpStatus.BAD_REQUEST),

    INTERNAL_SERVER_ERROR_NOT_FOUND_DATA(5001, "Sunucu Hatası : Liste getirilemedi. Lütfen tekrar deneyin.", HttpStatus.INTERNAL_SERVER_ERROR),
    INTERNAL_SERVER_ERROR(5002, "Sunucuda beklenmeyen bir hata oluştu. Lütfen tekrar deneyiniz.", HttpStatus.INTERNAL_SERVER_ERROR),
    ;


    private Integer code;
    private String message;
    private HttpStatus httpStatus;
}
