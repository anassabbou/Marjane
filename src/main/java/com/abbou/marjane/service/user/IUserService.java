package com.abbou.marjane.service.user;

import com.abbou.marjane.dtos.UserDto;
import com.abbou.marjane.model.User;
import com.abbou.marjane.request.CreateUserRequest;
import com.abbou.marjane.request.UserUpdateRequest;

public interface IUserService {
        User createUser(CreateUserRequest request);
        User updateUser(UserUpdateRequest request, Long userId);
        User getUserById(Long userId);
        void deleteUser(Long userId);
    
        UserDto convertUserToDto(User user);
    }
    