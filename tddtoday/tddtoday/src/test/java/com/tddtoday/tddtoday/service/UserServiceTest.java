package com.tddtoday.tddtoday.service;


import com.tddtoday.tddtoday.dto.UserDTO;
import com.tddtoday.tddtoday.entity.UserEntity;
import com.tddtoday.tddtoday.mapper.UserMapper;
import com.tddtoday.tddtoday.repository.UserRepository;
import com.tddtoday.tddtoday.service.impl.UserServiceImpl;
import com.tddtoday.tddtoday.utils.UserDataGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl underTest;

    @Test
    void shouldSaveUserEntity() {
        // given
        UserDTO userDTO = UserDTO.builder()
                .password("123")
                .username("romek")
                .email("romek@wp.pl").build();
        UserEntity userEntity = UserDataGenerator.getExampleUserEntity();

        when(userMapper.mapToUserEntity(userDTO)).thenReturn(userEntity);
        when(passwordEncoder.encode("123"))
                .thenReturn("$2a$12$MAInYawcsPlsBBSkBgis0ePGrgdl8dDVvlly.lWFhkdwLVx4yzRmW");

        // when
        underTest.register(userDTO);

        // then
        ArgumentCaptor<UserEntity> userEntityArgumentCaptor = ArgumentCaptor.forClass(UserEntity.class);

        verify(userRepository).save(userEntityArgumentCaptor.capture());

        UserEntity capturedUserEntity = userEntityArgumentCaptor.getValue();

        assertEquals("romek", capturedUserEntity.getUsername());
        assertEquals("$2a$12$MAInYawcsPlsBBSkBgis0ePGrgdl8dDVvlly.lWFhkdwLVx4yzRmW", capturedUserEntity.getPassword());
        assertEquals("romek@wp.pl", capturedUserEntity.getEmail());
    }
}
