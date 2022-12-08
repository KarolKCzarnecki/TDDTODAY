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

import javax.transaction.Transactional;
import javax.validation.Valid;

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
    public void deleteById(long id) {
        Optional<AbcdTestEntity> abcdTestEntityOptional = abcdTestRepository.findById(id);

        abcdTestEntityOptional.orElseThrow(
                () -> new AbcdTestNotFoundException("Test abcd with id: %d not found"
                        .formatted(id)));

        abcdTestRepository.deleteById(id);
    }

    @Override
    public AbcdTestEntity getById(long id) {
        return abcdTestRepository.findById(id).orElseThrow(
                () -> new AbcdTestNotFoundException("Test abcd with id: %d not found".formatted(id)));
    }


    // dodane 8.12
    @Override
    public AbcdTestEntity patchAnswerAById(AbcdTestDTO abcdTestDTO, long id,  String answerA) {
        Optional<AbcdTestEntity> abcdTestEntityOptional = abcdTestRepository.findById(id);

        abcdTestEntityOptional.orElseThrow(
                () -> new AbcdTestNotFoundException("Test abcd with id: %d not found"
                        .formatted(id)));


//        final String answerA = abcdTestDTO.getAnswerA();
        AbcdTestEntity abcdTestEntity = abcdTestMapper.mapToAbcdTestEntity(abcdTestDTO);
        abcdTestEntity.setAnswerA(answerA);
        abcdTestRepository.save(id);
    }

    @Override
    public AbcdTestEntity patchAnswerBById(AbcdTestDTO abcdTestDTO, long id ,  String answerB) {
        Optional<AbcdTestEntity> abcdTestEntityOptional = abcdTestRepository.findById(id);

        abcdTestEntityOptional.orElseThrow(
                () -> new AbcdTestNotFoundException("Test abcd with id: %d not found"
                        .formatted(id)));


//        final String newAnswerB = abcdTestDTO.getAnswerB();
        AbcdTestEntity abcdTestEntity = abcdTestMapper.mapToAbcdTestEntity(abcdTestDTO);
        abcdTestEntity.setAnswerB(answerB);
        abcdTestRepository.save(id);
    }

    @Override
    public AbcdTestEntity patchAnswerCById(AbcdTestDTO abcdTestDTO,long id,  String answerC) {
        Optional<AbcdTestEntity> abcdTestEntityOptional = abcdTestRepository.findById(id);

        abcdTestEntityOptional.orElseThrow(
                () -> new AbcdTestNotFoundException("Test abcd with id: %d not found"
                        .formatted(id)));



        AbcdTestEntity abcdTestEntity = abcdTestMapper.mapToAbcdTestEntity(abcdTestDTO);
        abcdTestEntity.setAnswerC(answerC);
        abcdTestRepository.save(id);
    }

    @Override
    public AbcdTestEntity patchAnswerDById(AbcdTestDTO abcdTestDTO, long id ,  String answerD) {
        Optional<AbcdTestEntity> abcdTestEntityOptional = abcdTestRepository.findById(id);

        abcdTestEntityOptional.orElseThrow(
                () -> new AbcdTestNotFoundException("Test abcd with id: %d not found"
                        .formatted(id)));


//        final String answerD = abcdTestDTO.getAnswerD();
        AbcdTestEntity abcdTestEntity = abcdTestMapper.mapToAbcdTestEntity(abcdTestDTO);
        abcdTestEntity.setAnswerD(answerD);
        abcdTestRepository.save(id);
    }




    @Override
    public AbcdTestEntity patchQuestionById(AbcdTestDTO abcdTestDTO,long id,  String question) {
        Optional<AbcdTestEntity> abcdTestEntityOptional = abcdTestRepository.findById(id);

        abcdTestEntityOptional.orElseThrow(
                () -> new AbcdTestNotFoundException("Test abcd with id: %d not found"
                        .formatted(id)));



        AbcdTestEntity abcdTestEntity = abcdTestMapper.mapToAbcdTestEntity(abcdTestDTO);
        abcdTestEntity.setQuestion(question);
        abcdTestRepository.save(id);
    }




    @Override
    public AbcdTestEntity patchCorrectAnswerById(long id) {
        Optional<AbcdTestEntity> abcdTestEntityOptional = abcdTestRepository.findById(id);

        abcdTestEntityOptional.orElseThrow(
                () -> new AbcdTestNotFoundException("Test abcd with id: %d not found"
                        .formatted(id)));


        final String newCorrectAnswer = abcdTestDTO.getCorrectAnswer();
        AbcdTestEntity abcdTestEntity = abcdTestMapper.mapToAbcdTestEntity(abcdTestDTO);
        abcdTestEntity.setCorrectAnswer(newCorrectAnswer);
        abcdTestRepository.save(id);
    }

}
