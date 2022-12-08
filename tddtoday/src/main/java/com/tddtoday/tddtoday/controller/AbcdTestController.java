package com.tddtoday.tddtoday.controller;

import com.tddtoday.tddtoday.dto.AbcdTestDTO;
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
    public ResponseEntity<Void> addAbcdTest(@RequestBody @Valid AbcdTestDTO abcdTestDTO){
        log.info("Trying to add test abcd with question: {}", abcdTestDTO.getQuestion());
        abcdTestService.addAbcdTest(abcdTestDTO);
        return  ResponseEntity.status(HttpStatus.OK).build();

    }

     @DeleteMapping("/delete/{idAbcdTest}")
    public ResponseEntity<Void> delete(@PathVariable long idAbcdTest) {
        log.info("Trying to delete test abcd with id: {}", idAbcdTest);
        abcdTestService.deleteById(idAbcdTest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }




}
