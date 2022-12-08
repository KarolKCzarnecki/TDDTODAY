package com.tddtoday.tddtoday.repository;

import com.tddtoday.tddtoday.entity.AbcdTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AbcdTestRepository extends JpaRepository<AbcdTestEntity, Long> {
}
