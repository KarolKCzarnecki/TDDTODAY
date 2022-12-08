package com.tddtoday.tddtoday.controller;

import com.tddtoday.tddtoday.dto.AbcdTestDTO;
import com.tddtoday.tddtoday.entity.AbcdTestEntity;
import com.tddtoday.tddtoday.repository.AbcdTestRepository;
import com.tddtoday.tddtoday.service.AbcdTestService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
public class AbcdTestController {

    private final AbcdTestService abcdTestService;


    @PostMapping("/addAbcdTest")
    public ResponseEntity<Void> addAbcdTest(@RequestBody @Valid AbcdTestDTO abcdTestDTO) {
        log.info("Trying to add test abcd with question: {}", abcdTestDTO.getQuestion());
        abcdTestService.addAbcdTest(abcdTestDTO);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        log.info("Trying to delete test abcd with id: {}", id);
        abcdTestService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    /// tutaj lece z domysłu 8.12


    @GetMapping("/{id}")
    public ResponseEntity<Void> readById(@PathVariable long id) {
        log.info("Trying to read test abcd with id: {}", id);

        abcdTestService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
//

    }

    @PatchMapping("/{id}/{answerA}")
    public ResponseEntity<Void> patchAnswerAById( @PathVariable long id, @PathVariable String answerA){
        log.info("Trying to replace Answer A with id: {}", id);


            try {
                AbcdTestEntity abcdTestEntity = abcdTestRepository.findById(id).get();
                abcdTestEntity.setAnswerA(answerA);
                return new ResponseEntity<AbcdTestEntity>(abcdTestRepository.save(abcdTestEntity), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


    @PatchMapping("/{id}/{answerB}")
    public ResponseEntity<Void> patchAnswerBById(@PathVariable long id, @PathVariable String answerB){
        log.info("Trying to replace Answer B with id: {}", id);



        try {
            AbcdTestEntity abcdTestEntity = abcdTestRepository.findById(id).get();
            abcdTestEntity.setAnswerB(answerB);
            return new ResponseEntity<AbcdTestEntity>(abcdTestRepository.save(abcdTestEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PatchMapping("/{id}/{answerC}")
    public ResponseEntity<Void> patchAnswerCById(@RequestBody @Valid AbcdTestDTO abcdTestDTO , @PathVariable long id, @PathVariable String answerC){
        log.info("Trying to replace Answer C with id: {}", id);



        try {
            AbcdTestEntity abcdTestEntity = abcdTestRepository.findById(id).get();
            abcdTestEntity.setAnswerC(answerC);
            return new ResponseEntity<AbcdTestEntity>(abcdTestRepository.save(abcdTestEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PatchMapping("/{id}/{answerD}")
    public ResponseEntity<Void> patchAnswerDById(@RequestBody @Valid AbcdTestDTO abcdTestDTO ,  @PathVariable long id, @PathVariable String answerD){
        log.info("Trying to replace Answer D with id: {}", id);



        try {

            AbcdTestEntity abcdTestEntity = abcdTestRepository.findById(id).get();
            abcdTestEntity.setAnswerD(answerD);
            return new ResponseEntity<AbcdTestEntity>(abcdTestRepository.save(abcdTestEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PatchMapping("/{id}/{question}")
    public ResponseEntity<Void> patchQuestionById(@RequestBody @Valid AbcdTestDTO abcdTestDTO , @PathVariable long id, @PathVariable String question){
        log.info("Trying to replace Question  with id: {}", id);

        try {
            AbcdTestEntity abcdTestEntity = abcdTestRepository.findById(id).get();
            abcdTestEntity.setQuestion(question);
            return new ResponseEntity<AbcdTestEntity>(abcdTestRepository.save(abcdTestEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}/{correctAnswer}")
    public ResponseEntity<Void> patchCorrectAnswerById(@RequestBody @Valid AbcdTestDTO abcdTestDTO , @PathVariable long id, @PathVariable String correctAnswer){
        log.info("Trying to replace Correct Answer  with id: {}", id);

        try {
            AbcdTestEntity abcdTestEntity = abcdTestRepository.findById(id).get();
            abcdTestEntity.setCorrectAnswer(correctAnswer);
            return new ResponseEntity<AbcdTestEntity>(abcdTestRepository.save(abcdTestEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
