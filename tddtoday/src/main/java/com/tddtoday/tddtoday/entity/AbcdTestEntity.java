package com.tddtoday.tddtoday.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AbcdTest", schema = "public")

public class AbcdTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbcdTest;

    private String question;

    private String answerA;

    private String answerB;

    private String answerC;

    private String answerD;

    private String correctAnswer;



}
