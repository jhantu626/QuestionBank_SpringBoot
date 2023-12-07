package io.quizApp.controller;

import io.quizApp.models.Question;
import io.quizApp.models.Quiz;
import io.quizApp.response.QuizResponse;
import io.quizApp.service.QuizService;
import io.quizApp.wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizContoller {

	@Autowired
	private QuizService quizService;

	@PostMapping("create/")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
		return new ResponseEntity<>(quizService.createQuiz(category,numQ,title), HttpStatus.CREATED);
	}

	@GetMapping("getQuiz")
	public ResponseEntity<List<Quiz>> getAllQuiz(){
		return ResponseEntity.ok(quizService.getAllQuiz());
	}


	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable("id") Integer id){
		return new ResponseEntity<>(quizService.getQuizQuestion(id),HttpStatus.OK);
	}

	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<QuizResponse> quizResponses){
		return ResponseEntity.ok(quizService.calculateResult(id,quizResponses));
	}



}
