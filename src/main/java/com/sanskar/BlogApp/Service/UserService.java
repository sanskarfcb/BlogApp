package com.sanskar.BlogApp.Service;

import com.sanskar.BlogApp.Dtos.RegisterRequestDto;
import com.sanskar.BlogApp.Dtos.UserDto;

public interface UserService {
    UserDto registerUser(RegisterRequestDto requestDto);
}
