package entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "blogposts")
@Getter
@Setter
@NoArgsConstructor
public class BlogPost {
	@Id
	@GeneratedValue
	private UUID id;
	private String title;
	private String content;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;

	public BlogPost(String title, String content, User user) {
		this.title = title;
		this.content = content;
		this.user = user;
	}

	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

}
