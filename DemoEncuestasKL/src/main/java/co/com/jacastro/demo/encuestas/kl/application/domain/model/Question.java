package co.com.jacastro.demo.encuestas.kl.application.domain.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Question {

	private Integer id;
	private String title;
	private List<QuestionResponse> response;

	public Question(Integer id, String title) {
		this.id = id;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<QuestionResponse> getResponse() {
		if (response == null)
			response = new LinkedList<>();
		return response;
	}

	public void setResponse(List<QuestionResponse> response) {
		this.response = response;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, response, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(id, other.id) && Objects.equals(response, other.response)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", response=" + response + "]";
	}

}
