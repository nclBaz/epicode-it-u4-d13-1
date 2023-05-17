package entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private UUID id;
	private String firstName;
	private String lastName;
	private int age;
	private String country;

//	@Embedded
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "document_id", referencedColumnName = "id")
	private Document document;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<BlogPost> blogPosts;

	public User(String firstName, String lastName, int age, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", country="
				+ country + ", document=" + document + "]";
	}

}
