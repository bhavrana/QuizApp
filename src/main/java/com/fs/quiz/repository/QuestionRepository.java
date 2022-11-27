package com.fs.quiz.repository;

import com.fs.quiz.domain.Question;
import com.fs.quiz.domain.QuizCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Question Repository Interface
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT q FROM Question q where q.quizCategory.id = :id")
    List<Question> findAllQuestionsByCategory( @Param("id") Long id);

    //List<Question> findQuestionByQuizCategory_Id(Long id);
}
