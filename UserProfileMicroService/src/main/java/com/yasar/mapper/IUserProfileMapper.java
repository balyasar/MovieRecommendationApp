package com.yasar.mapper;

import com.yasar.dto.request.UserProfileSaveRequestDto;
import com.yasar.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserProfileMapper {
    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);

    UserProfile fromUserProfileRequestDto(UserProfileSaveRequestDto dto);
}
