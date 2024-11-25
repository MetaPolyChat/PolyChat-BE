package com.polychat.polychatbe.user.command.application.dto;


import com.polychat.polychatbe.user.command.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserInfoMapper {
    UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);

    User toEntity(UserDTO userDTO);
    UserDTO toDto(User user);

    UserResponseDTO.UserInfoDTO toInfoDto(User entity);

    UserResponseDTO.UserMyProfileDTO toMyProfileDto(User user, List<String> interests);

    UserResponseDTO.UserProfileDTO toProfileDto(User user, List<String> interests);

}
