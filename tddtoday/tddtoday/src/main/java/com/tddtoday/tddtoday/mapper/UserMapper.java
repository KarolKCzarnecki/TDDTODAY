package com.tddtoday.tddtoday.mapper;

import com.tddtoday.tddtoday.dto.UserDTO;
import com.tddtoday.tddtoday.entity.UserEntity;

public interface UserMapper {
    UserEntity mapToUserEntity(UserDTO userDTO);

}

