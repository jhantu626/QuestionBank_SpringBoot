package io.quizApp.wrapper;

import io.quizApp.models.Question;

public class QuestionToWrapper {

	public static QuestionWrapper QuestionToWrapper(Question from){
		QuestionWrapper to=new QuestionWrapper();
		to.setId(from.getId());
		to.setOption1(from.getOption1());
		to.setOption2(from.getOption2());
		to.setOption3(from.getOption3());
		to.setOption4(from.getOption4());
		to.setDifficultyLevel(from.getDifficultyLevel());
		to.setCategory(from.getCategory());
		to.setQuestionTitle(from.getQuestionTitle());
		return to;
	}
}
