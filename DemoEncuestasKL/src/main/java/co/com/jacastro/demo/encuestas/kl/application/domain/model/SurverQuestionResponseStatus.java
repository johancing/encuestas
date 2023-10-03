package co.com.jacastro.demo.encuestas.kl.application.domain.model;

import java.util.Objects;

public class SurverQuestionResponseStatus {

	private Integer id;
	private String username;
	private Integer questionResponseId;
	private boolean seleted;

	public SurverQuestionResponseStatus(Integer id, String username, Integer questionResponseId, boolean seleted) {
		super();
		this.id = id;
		this.username = username;
		this.questionResponseId = questionResponseId;
		this.seleted = seleted;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getQuestionResponseId() {
		return questionResponseId;
	}

	public void setQuestionResponseId(Integer questionResponseId) {
		this.questionResponseId = questionResponseId;
	}

	public boolean isSeleted() {
		return seleted;
	}

	public void setSeleted(boolean seleted) {
		this.seleted = seleted;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, questionResponseId, seleted, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SurverQuestionResponseStatus other = (SurverQuestionResponseStatus) obj;
		return Objects.equals(id, other.id) && Objects.equals(questionResponseId, other.questionResponseId)
				&& seleted == other.seleted && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "SurverQuestionResponseStatus [id=" + id + ", username=" + username + ", questionResponseId="
				+ questionResponseId + ", seleted=" + seleted + "]";
	}

}
