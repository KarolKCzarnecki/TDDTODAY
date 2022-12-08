package com.tddtoday.tddtoday.service;


import com.tddtoday.tddtoday.dto.AbcdTestDTO;
import com.tddtoday.tddtoday.entity.AbcdTestEntity;
import com.tddtoday.tddtoday.mapper.AbcdTestMapper;
import com.tddtoday.tddtoday.repository.AbcdTestRepository;
import com.tddtoday.tddtoday.service.impl.AbcdTestServiceImpl;
import com.tddtoday.tddtoday.utils.AbcdTestDataGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AbcdTestServiceTest {

    @Mock
    private AbcdTestRepository abcdTestRepository;


    @Mock
    private AbcdTestMapper abcdTestMapper;

    @InjectMocks
    private AbcdTestServiceImpl underTest;

    @Test
    void shouldSaveAbcdTestEntity() {
        // given
        AbcdTestDTO abcdTestDTO = AbcdTestDTO.builder()

                .question("zaznacz poprawną kolejność przebiegu schematu działania TDD")
                .answerA("Faza Zielona, Faza Czerwona, Refakotryzacja")
                .answerB("Faza Czarna, Faza Zielona, Refakotryzacja")
                .answerC("Refaktoryzacja, Faza Zielona, Faza Czarna")
                .answerD("Faza Czerwona, Faza Zielona, Refaktoryzacja")
                .correctAnswer("Faza Czerwona, Faza Zielona, Refaktoryzacja")
                .result(true).build();


        AbcdTestEntity abcdTestEntity = AbcdTestDataGenerator.getExampleAbcdTestEntity();
        // when

        when(abcdTestMapper.mapToAbcdTestEntity(abcdTestDTO)).thenReturn(abcdTestEntity);
        underTest.addAbcdTest(abcdTestDTO);

        // then
        ArgumentCaptor<AbcdTestEntity> abcdTestEntityArgumentCaptor = ArgumentCaptor.forClass(AbcdTestEntity.class);

        verify(abcdTestRepository).save(abcdTestEntityArgumentCaptor.capture());

        AbcdTestEntity capturedAbcdTestEntity = abcdTestEntityArgumentCaptor.getValue();

        assertEquals("zaznacz poprawną kolejność przebiegu schematu działania TDD", capturedAbcdTestEntity.getQuestion());
        assertEquals("Faza Zielona, Faza Czerwona, Refakotryzacja", capturedAbcdTestEntity.getAnswerA());
        assertEquals("Faza Czarna, Faza Zielona, Refakotryzacja", capturedAbcdTestEntity.getAnswerB());
        assertEquals("Refaktoryzacja, Faza Zielona, Faza Czarna", capturedAbcdTestEntity.getAnswerC());
        assertEquals("Faza Czerwona, Faza Zielona, Refaktoryzacja", capturedAbcdTestEntity.getAnswerD());
        assertEquals("Faza Czerwona, Faza Zielona, Refaktoryzacja", capturedAbcdTestEntity.getCorrectAnswer());
        assertEquals(true , capturedAbcdTestEntity.getResult());

    }

}
