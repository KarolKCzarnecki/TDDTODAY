package com.tddtoday.tddtoday.utils;

import com.tddtoday.tddtoday.entity.UserEntity;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class UserDataGenerator {

    public static UserEntity getExampleUserEntity() {
        return UserEntity.builder()
                .password("123")
                .username("romek")
                .email("romek@wp.pl").build();
    }

}
