package com.yasar.service;

import com.yasar.dto.request.RegisterRequestDto;
import com.yasar.dto.response.RegisterResponseDto;
import com.yasar.entity.Auth;
import com.yasar.exception.AuthException;
import com.yasar.exception.ErrorType;
import com.yasar.mapper.IAuthMapper;
import com.yasar.repository.IAuthRepository;
import com.yasar.utility.CodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IAuthRepository repository;

    public RegisterResponseDto register(RegisterRequestDto dto) {
        Auth auth = IAuthMapper.INSTANCE.fromRegisterDto(dto);

        if (repository.existsByUserName(dto.getUserName()))
            throw new AuthException(ErrorType.USERNAME_ALREADY_EXIST);

        String activationCode = CodeGenerator.generatorCode();
        auth.setActivationCode(activationCode);
        repository.save(auth);

        RegisterResponseDto responseDto = IAuthMapper.INSTANCE.toRegisterResponseDto(auth);
        return responseDto;
    }


}
