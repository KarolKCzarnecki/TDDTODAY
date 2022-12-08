package com.tddtoday.tddtoday.service.impl;

import com.tddtoday.tddtoday.dto.AbcdTestDTO;
import com.tddtoday.tddtoday.entity.AbcdTestEntity;
import com.tddtoday.tddtoday.exception.AbcdTestNotFoundException;
import com.tddtoday.tddtoday.mapper.AbcdTestMapper;
import com.tddtoday.tddtoday.repository.AbcdTestRepository;
import com.tddtoday.tddtoday.service.AbcdTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class AbcdTestServiceImpl implements AbcdTestService {


    private final AbcdTestRepository abcdTestRepository;


    private final AbcdTestMapper abcdTestMapper;


    @Override
    public void addAbcdTest(AbcdTestDTO abcdTestDTO) {

        AbcdTestEntity abcdTestEntity = abcdTestMapper.mapToAbcdTestEntity(abcdTestDTO);

        abcdTestRepository.save(abcdTestEntity);
    }

    @Override
    public void deleteById(long idAbcdTest) {
        Optional<AbcdTestEntity> abcdTestEntityOptional = abcdTestRepository.findById(idAbcdTest);

        abcdTestEntityOptional.orElseThrow(
                () -> new AbcdTestNotFoundException("Test abcd with id: %d not found"
                        .formatted(idAbcdTest)));

        abcdTestRepository.deleteById(idAbcdTest);
    }

    @Override
    public AbcdTestEntity getById(long idAbcdTest) {
        return abcdTestRepository.findById(idAbcdTest).orElseThrow(
                () -> new AbcdTestNotFoundException("Test abcd with id: %d not found".formatted(idAbcdTest)));
    }
//
}
