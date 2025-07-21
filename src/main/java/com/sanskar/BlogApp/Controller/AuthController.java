package com.sanskar.BlogApp.Controller;

import com.sanskar.BlogApp.Dtos.RegisterRequestDto;
import com.sanskar.BlogApp.Dtos.UserDto;
import com.sanskar.BlogApp.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody RegisterRequestDto request) {
        UserDto registered = userService.registerUser(request);
        return ResponseEntity.ok(registered);
    }

}
