package com.yasar.service;

import com.yasar.dto.request.ActivateRequestDto;
import com.yasar.dto.request.RegisterRequestDto;
import com.yasar.dto.response.RegisterResponseDto;
import com.yasar.entity.Auth;
import com.yasar.exception.AuthException;
import com.yasar.exception.ErrorType;
import com.yasar.manager.IUserProfileManager;
import com.yasar.mapper.IAuthMapper;
import com.yasar.repository.IAuthRepository;
import com.yasar.utility.CodeGenerator;
import com.yasar.utility.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final IAuthRepository repository;
    private final IUserProfileManager userManager;

    public RegisterResponseDto register(RegisterRequestDto dto) {
        Auth auth = IAuthMapper.INSTANCE.fromRegisterDto(dto);

        String activationCode = CodeGenerator.generatorCode();
        auth.setActivationCode(activationCode);
        repository.save(auth);

        // feign client ile haberleşme
        userManager.saveUserProfile(IAuthMapper.INSTANCE.toUserProfileSaveRequestDto(auth));

        RegisterResponseDto responseDto = IAuthMapper.INSTANCE.toRegisterResponseDto(auth);
        return responseDto;
    }

    public String activateStatus(ActivateRequestDto dto) {
        Optional<Auth> auth = repository.findById(dto.getId());
        if (auth.isEmpty())
            throw new AuthException(ErrorType.USER_NOT_FOUND);
        if (auth.get().getStatus().equals(EStatus.ACTIVE))
            throw new AuthException(ErrorType.USER_ALREADY_ACTIVE);
        if (auth.get().getActivationCode().equals(dto.getActivationCode())) {
            auth.get().setStatus(EStatus.ACTIVE);
            repository.save(auth.get());
            userManager.activateStatus(auth.get().getId());
            return "Aktivasyon başarılı.";
        } else
            throw new AuthException(ErrorType.INVALID_ACTIVATION_CODE);

    }
}
