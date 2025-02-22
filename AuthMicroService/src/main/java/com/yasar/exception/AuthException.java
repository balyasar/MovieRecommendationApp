package com.yasar.exception;

import lombok.Getter;

/**
 * Bir sınıfı Exception sınıfı olarak görev yapabilmesi için Exception ya da RuntimeException'dan miras
 * alması gerekir.
 * Eğer hata mesajı fırlatmak ve iletmek istiyorsanız miras aldığınız sınıfın
 * constructor'una super(message) hata ile ilgili mesajı iletiyorsunuz.
 */

@Getter
public class AuthException extends RuntimeException {
    private ErrorType errorType;

    public AuthException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public AuthException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType=errorType;
    }

}
