package entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "documents")
@Getter
@Setter
@NoArgsConstructor
@ToString
//@Embeddable
public class Document {
	@Id
	@GeneratedValue
	private UUID id;
	private LocalDate issueDate;
	private String code;
	@Column(length = 2)
	private String issueCountry;

	public Document(LocalDate issueDate, String code, String issueCountry) {
		super();
		this.issueDate = issueDate;
		this.code = code;
		this.issueCountry = issueCountry;
	}

}
