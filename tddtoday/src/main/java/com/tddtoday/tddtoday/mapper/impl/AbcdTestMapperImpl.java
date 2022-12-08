package com.tddtoday.tddtoday.mapper.impl;



import com.tddtoday.tddtoday.dto.AbcdTestDTO;
import com.tddtoday.tddtoday.entity.AbcdTestEntity;
import com.tddtoday.tddtoday.mapper.AbcdTestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
@Slf4j
@Component
@RequiredArgsConstructor
public class AbcdTestMapperImpl implements AbcdTestMapper {


    private final ObjectMapper objectMapper;

      @Override
        public AbcdTestEntity mapToAbcdTestEntity(AbcdTestDTO abcdtestDTO) {
            log.info("Trying to map AbcdTestDTO -> AbcdTestEntity");
            return objectMapper.convertValue(abcdtestDTO, AbcdTestEntity.class);
        }


}
