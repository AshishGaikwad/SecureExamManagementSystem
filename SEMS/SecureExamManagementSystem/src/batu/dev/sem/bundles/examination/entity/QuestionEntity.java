package batu.dev.sem.bundles.examination.entity;

import com.google.gson.Gson;

public class QuestionEntity 
{
	private long id;
	private long subjectId;
	private String question;
	private String options;
	private int correctAnswer;
	private int marks;
	
	
	
	
	
	public int getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(int correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
	
	
}
