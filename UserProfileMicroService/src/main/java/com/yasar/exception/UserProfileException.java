package com.yasar.exception;

import lombok.Getter;

/**
 * Bir sınıfı Exception sınıfı olarak görev yapabilmesi için Exception ya da RuntimeException'dan miras
 * alması gerekir.
 * Eğer hata mesajı fırlatmak ve iletmek istiyorsanız miras aldığınız sınıfın
 * constructor'una super(message) hata ile ilgili mesajı iletiyorsunuz.
 */

@Getter
public class UserProfileException extends RuntimeException {
    private ErrorType errorType;

    public UserProfileException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

}
