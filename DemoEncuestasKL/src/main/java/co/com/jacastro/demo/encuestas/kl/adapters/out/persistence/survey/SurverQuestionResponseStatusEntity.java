package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.survey;

import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "survey_questions_response", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "questionResponseId", "username" }) })
public class SurverQuestionResponseStatusEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private Integer questionResponseId;
	private boolean selected;

	public SurverQuestionResponseStatusEntity() {
	}

	public SurverQuestionResponseStatusEntity(String username, Integer questionResponseId, boolean selected) {
		super();
		this.username = username;
		this.questionResponseId = questionResponseId;
		this.selected = selected;
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, questionResponseId, selected, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SurverQuestionResponseStatusEntity other = (SurverQuestionResponseStatusEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(questionResponseId, other.questionResponseId)
				&& selected == other.selected && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "SurverQuestionResponseStatusEntity [id=" + id + ", username=" + username + ", questionResponseId="
				+ questionResponseId + ", selected=" + selected + "]";
	}

}
