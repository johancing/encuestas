package co.com.jacastro.demo.encuestas.kl.application.domain.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Survey {

	private List<Question> questions;

	public List<Question> getQuestions() {
		if (questions == null)
			questions = new LinkedList<>();
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(questions);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Survey other = (Survey) obj;
		return Objects.equals(questions, other.questions);
	}

	@Override
	public String toString() {
		return "survey [questions=" + questions + "]";
	}

}
