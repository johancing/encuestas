package co.com.jacastro.demo.encuestas.kl.adapters.out.persistence.survey;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "question")
public class QuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String title;
	@OneToMany(mappedBy = "questionId", cascade = CascadeType.ALL)
	private List<QuestionResponseEntity> response;
	
	public QuestionEntity() {
	}

	public QuestionEntity(Integer id, String title, List<QuestionResponseEntity> response) {
		super();
		this.id = id;
		this.title = title;
		this.response = response;
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

	public List<QuestionResponseEntity> getResponse() {
		if (response == null)
			response = new LinkedList<>();
		return response;
	}

	public void setResponse(List<QuestionResponseEntity> response) {
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
		QuestionEntity other = (QuestionEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(response, other.response)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "QuestionEntity [id=" + id + ", title=" + title + ", response=" + response + "]";
	}

}
