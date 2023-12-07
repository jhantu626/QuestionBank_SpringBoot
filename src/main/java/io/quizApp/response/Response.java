package io.quizApp.response;

import io.quizApp.models.Question;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response {
	private String message;
	private boolean flag;
	private Question question;
	public Response(String message,Question question){
		this.question=question;
		this.message=message;
	}
	public Response(String message,boolean flag){
		this.flag=flag;
		this.message=message;
	}

}
