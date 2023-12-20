package com.group9.group09.service.interfaces;

import com.group9.group09.DTO.RequestDTO.RequestDTO;
import com.group9.group09.DTO.RequestDTO.UserProfileRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ResponseDTO;
import com.group9.group09.DTO.RequestDTO.UserEditRequestDTO;
import com.group9.group09.DTO.ResponseDTO.UserProfileResponseDTO;
import com.group9.group09.model.User;

public interface UserService {

    ResponseDTO loginUserService(User user);

    ResponseDTO registerUserService(User user);

    ResponseDTO updateUserpasswordService(UserEditRequestDTO userEditRequestDTO);

    User getUserbyEmail(UserEditRequestDTO userEditRequestDTO);

    ResponseDTO updateUserphoneNumberService(User user);

    UserProfileResponseDTO getUserDetails(RequestDTO requestDTO);

    ResponseDTO setUserDetails(UserProfileRequestDTO requestDTO);
}
