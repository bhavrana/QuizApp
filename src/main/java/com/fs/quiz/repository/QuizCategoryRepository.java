package com.fs.quiz.repository;

import com.fs.quiz.domain.QuizCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizCategoryRepository extends JpaRepository<QuizCategory, Long> {
    QuizCategory findQuizCategoryByCategoryName(String categoryName);
}
