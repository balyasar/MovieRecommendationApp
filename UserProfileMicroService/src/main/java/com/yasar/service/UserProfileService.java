package com.yasar.service;

import com.yasar.dto.request.UpdateEmailAndUserNameRequestDto;
import com.yasar.dto.request.UserProfileSaveRequestDto;
import com.yasar.dto.request.UserProfileUpdateRequestDto;
import com.yasar.entity.UserProfile;
import com.yasar.exception.ErrorType;
import com.yasar.exception.UserProfileException;
import com.yasar.manager.IAuthManager;
import com.yasar.mapper.IUserProfileMapper;
import com.yasar.repository.UserProfileRepository;
import com.yasar.utility.EStatus;
import com.yasar.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository repository;
    private final JwtTokenManager tokenManager;
    private final IAuthManager authManager;

    public Object saveUserProfile(UserProfileSaveRequestDto dto) {
        return repository.save(IUserProfileMapper.INSTANCE.fromUserProfileRequestDto(dto));
    }

    public String activateStatus(Long authId) {
        Optional<UserProfile> userProfile = repository.findByAuthId(authId);
        if (userProfile.isEmpty())
            throw new UserProfileException(ErrorType.USER_NOT_FOUND);
        userProfile.get().setStatus(EStatus.ACTIVE);
        repository.save(userProfile.get());
        return "Aktivasyon Başarılı";
    }

    public String updateUserProfile(UserProfileUpdateRequestDto dto) {
        Long authId = tokenManager.getAuthIdFromToken(dto.getToken())
                .orElseThrow(() -> new UserProfileException(ErrorType.INVALID_TOKEN));
        UserProfile user = repository.findByAuthId(authId)
                .orElseThrow(() -> new UserProfileException(ErrorType.USER_NOT_FOUND));
        if (!dto.getUserName().equals(user.getUserName()) || !dto.getEmail().equals(user.getEmail())) {
            user.setUserName(dto.getUserName());
            user.setEmail(dto.getEmail());
            // authservice'a istek atacağız.
            authManager.updateEmailAndUserName(UpdateEmailAndUserNameRequestDto.builder()
                    .email(dto.getEmail())
                    .userName(dto.getUserName())
                    .build());
        }

        user.setPhone(dto.getPhone());
        user.setAbout(dto.getAbout());
        user.setAddress(dto.getAddress());
        user.setName(dto.getName());
        user.setSurName(dto.getSurName());
        user.setAvatar(dto.getAvatar());
        user.setBirthDate(dto.getBirthDate());

        repository.save(user);
        return "Bilgileriniz güncellendi.";

    }
}
