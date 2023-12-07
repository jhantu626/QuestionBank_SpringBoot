package io.quizApp.service;

import io.quizApp.Exceptions.NotFoundException;
import io.quizApp.dao.questionDao;
import io.quizApp.models.Question;
import io.quizApp.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

	@Autowired
	questionDao dao;

	public List<Question> getAllQuestion(){
		return dao.findAll();
	}

	public Question addQuestion(Question question) {
		return dao.save(question);
	}

	public List<Question> getQuestionByCategory(String category) {
		return dao.findByCategory(category);
	}

	public Response deleteQuestion(Integer id) {
			dao.deleteById(id);

		return new Response("Question Deleted Successfully",true);
	}

	public Question getQuestionById(Integer id) {
		return dao.findById(id).get();
	}

	public Response updateQuestion(Question question) {
		Question question1 = dao.findById(question.getId()).get();
		if (question1 == null) {
			return new Response("Not Found", question1);
		}
		question1.setCategory(question.getCategory());
		question1.setDifficultyLevel(question.getDifficultyLevel());
		question1.setOption1(question.getOption1());
		question1.setOption2(question.getOption2());
		question1.setOption3(question.getOption3());
		question1.setOption4(question.getOption4());
		question1.setQuestionTitle(question.getQuestionTitle());
		question1.setRightAnswer(question.getRightAnswer());
		return new Response("Found", dao.save(question1));
	}
}
