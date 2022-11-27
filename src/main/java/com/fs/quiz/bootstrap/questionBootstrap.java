package com.fs.quiz.bootstrap;

import com.fs.quiz.domain.Question;
import com.fs.quiz.domain.QuizCategory;
import com.fs.quiz.repository.QuestionRepository;
import com.fs.quiz.repository.QuizCategoryRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Component
public class questionBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final QuestionRepository questionRepository;

    private final QuizCategoryRepository quizCategoryRepository;

    public questionBootstrap(QuestionRepository questionRepository, QuizCategoryRepository quizCategoryRepository1) {
        this.questionRepository = questionRepository;
        this.quizCategoryRepository = quizCategoryRepository1;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        questionRepository.saveAll(getQuestions());
    }

    private List<Question> getQuestions() {
        List<Question> questionList =new LinkedList<>();

        QuizCategory geography = new QuizCategory();
        geography.setCategoryName("geography");

        Question q1 = new Question();
        q1.setQuestion("What is the capital of Cuba?");
        q1.setAnswer("Havana");
        q1.setQuizCategory(geography);

        Question q2 = new Question();
        q2.setQuestion("What is the capital of France?");
        q2.setAnswer("Paris");
        q2.setQuizCategory(geography);

        Question q3 = new Question();
        q3.setQuestion("What is the capital of Poland?");
        q3.setAnswer("Warsaw");
        q3.setQuizCategory(geography);

        Question q4 = new Question();
        q4.setQuestion("What is the capital of Germany?");
        q4.setAnswer("Berlin");
        q4.setQuizCategory(geography);

        questionList.add(q1);
        questionList.add(q2);
        questionList.add(q3);
        questionList.add(q4);

        geography.addQuestion(q1);
        geography.addQuestion(q2);
        geography.addQuestion(q3);
        geography.addQuestion(q4);

        quizCategoryRepository.save(geography);
//-------------------------------------------------------
        QuizCategory science = new QuizCategory();
        science.setCategoryName("science");

        Question q5 = new Question();
        q5.setQuestion("What Is The Heaviest Organ In The Human Body?");
        q5.setAnswer("Liver");
        q5.setQuizCategory(science);

        Question q6 = new Question();
        q6.setQuestion("What Is The Only Planet That Spins Clockwise?");
        q6.setAnswer("Venus");
        q6.setQuizCategory(science);

        Question q7 = new Question();
        q7.setQuestion("The Horsehead Nebula Can Be Found In What Constellation?");
        q7.setAnswer("Orion");
        q7.setQuizCategory(science);

        Question q8 = new Question();
        q8.setQuestion("The World’s Fastest-Growing Plant Is A Species Of What?");
        q8.setAnswer("Bamboo");
        q8.setQuizCategory(science);

        questionList.add(q5);
        questionList.add(q6);
        questionList.add(q7);
        questionList.add(q8);

        science.addQuestion(q5);
        science.addQuestion(q6);
        science.addQuestion(q7);
        science.addQuestion(q8);

        quizCategoryRepository.save(science);

        return questionList;
    }
}
