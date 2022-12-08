package com.tddtoday.tddtoday.mapper.impl;


import com.tddtoday.tddtoday.dto.UserDTO;
import com.tddtoday.tddtoday.entity.UserEntity;
import com.tddtoday.tddtoday.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
@Slf4j
@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final ObjectMapper objectMapper;

    @Override
    public UserEntity mapToUserEntity(UserDTO userDTO) {
        log.info("Trying to map UserDTO -> UserEntity");
        return objectMapper.convertValue(userDTO, UserEntity.class);
    }

}