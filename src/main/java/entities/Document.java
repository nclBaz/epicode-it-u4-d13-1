package entities;

import java.time.LocalDate;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Entity
// @Table(name = "documents")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Embeddable
public class Document {
//	@Id
//	@GeneratedValue
//	private UUID id;
	private LocalDate issueDate;
	private String code;
	private String issueCountry;
}
