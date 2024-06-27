package com.yasar.service;

import com.yasar.dto.request.UserProfileSaveRequestDto;
import com.yasar.entity.UserProfile;
import com.yasar.exception.ErrorType;
import com.yasar.exception.UserProfileException;
import com.yasar.mapper.IUserProfileMapper;
import com.yasar.repository.UserProfileRepository;
import com.yasar.utility.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository repository;

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
}
