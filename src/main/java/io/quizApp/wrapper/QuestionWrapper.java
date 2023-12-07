package io.quizApp.wrapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionWrapper {
	private Integer id;
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String difficultyLevel;
	private String category;
}