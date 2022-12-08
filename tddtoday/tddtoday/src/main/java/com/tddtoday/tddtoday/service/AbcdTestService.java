package com.tddtoday.tddtoday.service;

import com.tddtoday.tddtoday.entity.AbcdTestEntity;
import com.tddtoday.tddtoday.dto.AbcdTestDTO;


public interface AbcdTestService {

    void addAbcdTest(AbcdTestDTO abcdTestDTO);

    void deleteById(long id);

    AbcdTestEntity getById(long id);

    //dodane 8.12

    AbcdTestEntity patchAnswerAById(AbcdTestDTO abcdTestDTO, long id, String answerA);

    AbcdTestEntity patchAnswerBById(AbcdTestDTO abcdTestDTO,long id, String answerB);

    AbcdTestEntity patchAnswerCById(AbcdTestDTO abcdTestDTO,long id, String answerC);

    AbcdTestEntity patchAnswerDById(AbcdTestDTO abcdTestDTO,long id, String answerC);

    AbcdTestEntity patchQuestionById(AbcdTestDTO abcdTestDTO,long id, String answerD);

    AbcdTestEntity patchCorrectAnswerById(AbcdTestDTO abcdTestDTO,long id, String correctAnswer);


    AbcdTestEntity readById(long id);
}
