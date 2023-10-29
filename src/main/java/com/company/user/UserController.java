package com.company.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody UserDto dto) {
        String role = dto.getRole();
        Optional<User> user = userRepository.findByName(dto.getName());
        if (userService.isRoleValid(role) && user.isEmpty()) {
            return ResponseEntity.ok(userRepository.save(new User(dto)));
        }
        return ResponseEntity.badRequest().build();
    }
}
