package com.fs.quiz.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class QuizCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quizCategory")
    private List<Question> questions = new LinkedList<>();

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
