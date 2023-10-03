package co.com.jacastro.demo.encuestas.kl.application.domain.model;

import java.util.Objects;

public class QuestionResponse {

	private Integer id;
	private Integer questionId;
	private String title;

	public QuestionResponse(Integer id, Integer questionId, String title) {
		this.id = id;
		this.questionId = questionId;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, questionId, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionResponse other = (QuestionResponse) obj;
		return Objects.equals(id, other.id) && Objects.equals(questionId, other.questionId)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "QuestionResponse [id=" + id + ", questionId=" + questionId + ", title=" + title + "]";
	}

}
