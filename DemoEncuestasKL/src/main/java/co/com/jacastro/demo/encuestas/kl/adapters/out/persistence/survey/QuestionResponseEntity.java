package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.survey;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "question_response", uniqueConstraints = { @UniqueConstraint(columnNames = { "id", "questionId" }) })
public class QuestionResponseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "questionId")
	private QuestionEntity questionId;
	private String title;
	private boolean isSelected;
	
	public QuestionResponseEntity() {
	}

	public QuestionResponseEntity(Integer id, QuestionEntity questionId, String title, boolean isSelected) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.title = title;
		this.isSelected = isSelected;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public QuestionEntity getQuestionId() {
		return questionId;
	}

	public void setQuestionId(QuestionEntity questionId) {
		this.questionId = questionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isSelected, questionId, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionResponseEntity other = (QuestionResponseEntity) obj;
		return Objects.equals(id, other.id) && isSelected == other.isSelected
				&& Objects.equals(questionId, other.questionId) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "QuestionResponseEntity [id=" + id + ", questionId=" + questionId + ", title=" + title + ", isSelected="
				+ isSelected + "]";
	}

}
