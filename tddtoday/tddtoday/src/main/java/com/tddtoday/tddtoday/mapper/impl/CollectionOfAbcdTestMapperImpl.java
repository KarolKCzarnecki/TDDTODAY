package com.tddtoday.tddtoday.mapper.impl;




import com.tddtoday.tddtoday.dto.CollectionOfAbcdTestDTO;
import com.tddtoday.tddtoday.entity.CollectionOfAbcdTestEntity;
import com.tddtoday.tddtoday.mapper.CollectionOfAbcdTestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
@Slf4j
@Component
@RequiredArgsConstructor
public class CollectionOfAbcdTestMapperImpl implements CollectionOfAbcdTestMapper {

    private final ObjectMapper objectMapper;

          @Override
        public CollectionOfAbcdTestEntity mapToCollectionOfAbcdTestEntity(CollectionOfAbcdTestDTO collectionOfabcdtestDTO) {
            log.info("Trying to map CollectionOfAbcdTestDTO -> CollectionOfAbcdTestEntity");
            return objectMapper.convertValue(collectionOfabcdtestDTO, CollectionOfAbcdTestEntity.class);
        }

}
