package com.tddtoday.tddtoday.service;

import com.tddtoday.tddtoday.dto.UserDTO;
import com.tddtoday.tddtoday.entity.UserEntity;

public interface UserService {

    void register(UserDTO userDTO);

    void deleteById(long id);

    UserEntity getById(long id);

}
