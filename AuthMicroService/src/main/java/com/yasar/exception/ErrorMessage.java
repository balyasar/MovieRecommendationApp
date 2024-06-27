package com.yasar.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // get, set, toString
@AllArgsConstructor // parametreli constructorların tümü
@NoArgsConstructor // default constructor
@Builder
public class ErrorMessage {
    private Integer code;
    private String message;
    /**
     * String password : @Valid, min=8, max=32 , en az bir büyük, bir küçük, özel karakter ....
     */
    private List<String> fields;
}
