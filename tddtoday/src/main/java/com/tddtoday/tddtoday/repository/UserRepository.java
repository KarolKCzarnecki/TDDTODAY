package com.tddtoday.tddtoday.repository;

import com.tddtoday.tddtoday.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

