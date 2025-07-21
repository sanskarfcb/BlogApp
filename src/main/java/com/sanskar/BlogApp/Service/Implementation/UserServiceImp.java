package com.sanskar.BlogApp.Service.Implementation;

import com.sanskar.BlogApp.Dtos.RegisterRequestDto;
import com.sanskar.BlogApp.Dtos.UserDto;
import com.sanskar.BlogApp.Entity.Roles;
import com.sanskar.BlogApp.Entity.User;
import com.sanskar.BlogApp.Repository.RoleRepository;
import com.sanskar.BlogApp.Repository.UserRepository;
import com.sanskar.BlogApp.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto registerUser(RegisterRequestDto requestDto) {
        User user = new User();
        user.setUsername(requestDto.getUsername());
        user.setEmail(requestDto.getEmail());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));

        Roles roles = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Default role not found"));
        user.setRoles(Set.of(roles));
        User savedUser = userRepository.save(user);
        return mapToDTO(savedUser);
    }
    private UserDto mapToDTO(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRoles(
                user.getRoles().stream().map(Roles::getName).collect(Collectors.toSet())
        );
        return dto;
    }
}
