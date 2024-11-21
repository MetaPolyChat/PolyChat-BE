package com.polychat.polychatbe.user.command.application.service;

import com.polychat.polychatbe.common.error.ApplicationException;
import com.polychat.polychatbe.common.error.ErrorCode;
import com.polychat.polychatbe.interest.command.application.service.InterestUserService;
import com.polychat.polychatbe.user.command.application.dto.UserDTO;
import com.polychat.polychatbe.user.command.application.dto.UserInfoMapper;
import com.polychat.polychatbe.user.command.application.dto.UserRequestDTO;
import com.polychat.polychatbe.user.command.application.dto.UserResponseDTO;
import com.polychat.polychatbe.user.command.domain.model.Authority;
import com.polychat.polychatbe.user.command.domain.model.User;
import com.polychat.polychatbe.user.command.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserInfoService {

    private final UserService userService;
    private final UserInfoMapper mapper;

    private final InterestUserService interestService;

    public Boolean findUserExist(Long id) {
        return userService.findExistUserById(id);
    }

    private User findUserByIdOrThrow(Long id){
        User user = userService.findUserById(id);
        if (user == null) {
            throw new ApplicationException(ErrorCode.NO_SUCH_USER);
        }
        return user;
    }



    @Transactional(readOnly = true)
    public UserResponseDTO.UserInfoDTO findUserById(Long id) {
        User user = this.findUserByIdOrThrow(id);

        if (Authority.ADMIN.equals(user.getAuthority())){
            throw new ApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }

        return mapper.toInfoDto(user);
    }

    @Transactional(readOnly = true)
    public UserResponseDTO.nickNameDTO findUserName(Long id) {
        User user = this.findUserByIdOrThrow(id);

        if (Authority.ADMIN.equals(user.getAuthority())){
            throw new ApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }

        return new UserResponseDTO.nickNameDTO(user.getUserName());
    }

    public UserResponseDTO.UserMyProfileDTO getMyProfile(Long userId) {
        User user = this.findUserByIdOrThrow(userId);
        List<String> interests = interestService.findInterestNamesByUserId(userId);
        return mapper.toMyProfileDto(user, interests);
    }

    public UserResponseDTO.UserProfileDTO findUserProfile(String planet) {
        User user = userService.findUserByPlanet(planet);
        if (user == null) {
            throw new ApplicationException(ErrorCode.NO_SUCH_USER);
        }
        List<String> interests = interestService.findInterestNamesByUserId(user.getUserId());
        return mapper.toProfileDto(user, interests);
    }
    public UserResponseDTO.UserProfileDTO findUserProfile(Long userId) {
        User user = this.findUserByIdOrThrow(userId);
        List<String> interests = interestService.findInterestNamesByUserId(userId);
        return mapper.toProfileDto(user, interests);
    }

    public void updateUserNickname(UserRequestDTO.UpdateNameDTO updateNameDTO) {
        User user = this.findUserByIdOrThrow(updateNameDTO.userId());
        UserDTO userDTO = mapper.toDto(user);
        userDTO.setUserName(updateNameDTO.userName());
        user = mapper.toEntity(userDTO);
        userService.updateUser(user);
    }
}
