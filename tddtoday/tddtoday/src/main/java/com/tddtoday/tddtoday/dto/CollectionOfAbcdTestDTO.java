package com.tddtoday.tddtoday.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CollectionOfAbcdTestDTO {


    @NotBlank(message = "Field 'collectionName' -> cannot be blank")
    private String collectionName;

    /// ma zliczać dobre odpowiedzi
    private  int countCorrectAnswers;

    // ma liczyć ile jest odpowiedzi w zestawie
    private int countAllAnswers;

    // równanie countAllAnswers - countCorrectAnswers
    private int score;

}
