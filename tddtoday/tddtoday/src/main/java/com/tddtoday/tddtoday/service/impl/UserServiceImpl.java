package com.tddtoday.tddtoday.service.impl;


import com.tddtoday.tddtoday.dto.UserDTO;
import com.tddtoday.tddtoday.entity.UserEntity;
import com.tddtoday.tddtoday.exception.UserNotFoundException;
import com.tddtoday.tddtoday.mapper.UserMapper;
import com.tddtoday.tddtoday.repository.UserRepository;
import com.tddtoday.tddtoday.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    @Override
    public void register(UserDTO userDTO) {
        final String hashPassword = passwordEncoder.encode(userDTO.getPassword());
        UserEntity userEntity = userMapper.mapToUserEntity(userDTO);
        userEntity.setPassword(hashPassword);
        userRepository.save(userEntity);
    }

    @Override
    public void deleteById(long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);

        userEntityOptional.orElseThrow(
                () -> new UserNotFoundException("User with id: %d not found"
                        .formatted(id)));

        userRepository.deleteById(id);
    }

    @Override
    public UserEntity getById(long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id: %d not found".formatted(id)));
    }





}
