package io.quizApp.controller;

import io.quizApp.models.Question;
import io.quizApp.response.Response;
import io.quizApp.service.QuestionService;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionService questionService;

//	@Hidden
	@PostMapping("/addQuestion")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		return new ResponseEntity<>(questionService.addQuestion(question), HttpStatus.CREATED);
	}

//	@Hidden
	@GetMapping("/id/allQuestion/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable("id") Integer id){
		return ResponseEntity.ok(questionService.getQuestionById(id));
	}
	@GetMapping("/allQuestion")
	public ResponseEntity<List<Question>> getAllQuestions(){
		return new ResponseEntity<>(questionService.getAllQuestion(),HttpStatus.FOUND);
	}

	@GetMapping("/category/allQuestion/{cat}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable("cat") String category){
		return ResponseEntity.ok(questionService.getQuestionByCategory(category));
	}

	@DeleteMapping("/deleteQuestion/id/{id}")
	public ResponseEntity<Response> deleteQuestionById(@PathVariable("id") Integer id){
		return ResponseEntity.ok(questionService.deleteQuestion(id));
	}


	@PutMapping("/update")
	public ResponseEntity<Response> updateQuestion(@RequestBody Question question){
		return new ResponseEntity<>(questionService.updateQuestion(question),HttpStatus.OK);
	}


}
