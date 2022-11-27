package com.fs.quiz.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String question;

    private String answer;

    @ManyToOne
    private QuizCategory quizCategory;
}
