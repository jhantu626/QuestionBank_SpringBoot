package io.quizApp.dao;

import io.quizApp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionDao extends JpaRepository<Question,Integer> {
	List<Question> findByCategory(String category);


}
