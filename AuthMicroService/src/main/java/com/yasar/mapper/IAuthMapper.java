package com.yasar.mapper;

import com.yasar.dto.request.RegisterRequestDto;
import com.yasar.dto.request.UserProfileSaveRequestDto;
import com.yasar.dto.response.RegisterResponseDto;
import com.yasar.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAuthMapper {
    IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);

    Auth fromRegisterDto(RegisterRequestDto dto);

    RegisterResponseDto toRegisterResponseDto(Auth auth);

    @Mapping(source = "id", target = "authId")
    UserProfileSaveRequestDto toUserProfileSaveRequestDto(Auth auth);
}
