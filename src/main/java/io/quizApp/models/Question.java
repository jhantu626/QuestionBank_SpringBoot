package io.quizApp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String rightAnswer;
	private String difficultyLevel;
	private String category;
}
