package com.tddtoday.tddtoday.utils;

import com.tddtoday.tddtoday.entity.AbcdTestEntity;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@UtilityClass
public class AbcdTestDataGenerator {


       public static AbcdTestEntity getExampleAbcdTestEntity() {
        return AbcdTestEntity.builder()
                .question("zaznacz poprawną kolejność przebiegu schematu działania TDD")
                .answerA("Faza Zielona, Faza Czerwona, Refakotryzacja")
                .answerB("Faza Czarna, Faza Zielona, Refakotryzacja")
                .answerC("Refaktoryzacja, Faza Zielona, Faza Czarna")
                .answerD("Faza Czerwona, Faza Zielona, Refaktoryzacja")
                .correctAnswer("Faza Czerwona, Faza Zielona, Refaktoryzacja")
                .result(true).build();
    }

}
