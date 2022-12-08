package com.tddtoday.tddtoday.controller;

import com.tddtoday.tddtoday.dto.UserDTO;
import com.tddtoday.tddtoday.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid UserDTO userDTO) {
        log.info("Trying to register user with username: {}", userDTO.getEmail());
        userService.register(userDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        log.info("Trying to delete user with id: {}", id);
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
