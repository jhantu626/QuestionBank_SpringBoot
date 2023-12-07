package io.quizApp.service;

import io.quizApp.Exceptions.NotFoundException;
import io.quizApp.dao.QuizDao;
import io.quizApp.models.Question;
import io.quizApp.models.Quiz;
import io.quizApp.response.QuizResponse;
import io.quizApp.wrapper.QuestionToWrapper;
import io.quizApp.wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import io.quizApp.dao.questionDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {
	@Autowired
	private QuizDao dao;

	@Autowired
	private questionDao questionDao;
	public String createQuiz(String category, int numQ, String title) {
		List<Question> questions=questionDao.findByCategory(category)
				.stream().limit(numQ).collect(Collectors.toList());
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		dao.save(quiz);
		return "Success";
	}

	public List<QuestionWrapper> getQuizQuestion(Integer id) {
		Optional<Quiz> quiz=dao.findById(id);
		List<Question> questionFromDb=quiz.get().getQuestions();
		List<QuestionWrapper> questionWrappers=new ArrayList<>();

		questionFromDb.forEach(t->{
			QuestionWrapper questionWrapper=QuestionToWrapper.QuestionToWrapper(t);
			questionWrappers.add(questionWrapper);
		});


		return questionWrappers;
	}

	public List<Quiz> getAllQuiz() {
		return dao.findAll();
	}

	public Integer calculateResult(Integer id, List<QuizResponse> quizResponses) {
		Quiz quiz=dao.findById(id).get();
		List<Question> questions=quiz.getQuestions();
		int right=0;
		int i=0;
		for (QuizResponse response:quizResponses){
			if (response.getResponse().equals(questions.get(i).getRightAnswer())){
				right++;
			}
			i++;
		}
		return right;
	}
}
