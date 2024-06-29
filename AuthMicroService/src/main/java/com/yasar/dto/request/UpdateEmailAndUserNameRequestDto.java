package com.yasar.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get, set, toString
@AllArgsConstructor // parametreli constructorların tümü
@NoArgsConstructor // default constructor
@Builder
public class UpdateEmailAndUserNameRequestDto {
    private Long id;
    private String email;
    private String UserName;
}
