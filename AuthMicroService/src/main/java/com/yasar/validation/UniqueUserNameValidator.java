package com.yasar.validation;

import com.yasar.repository.IAuthRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    private final IAuthRepository authRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !authRepository.existsByUserName(value);
    }
}
