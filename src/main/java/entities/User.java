package entities;

import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue
	private UUID id;
	private String firstName;
	private String lastName;
	private int age;
	private String country;

	@Embedded
	private Document document;

	public User(String firstName, String lastName, int age, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.country = country;
	}
}
