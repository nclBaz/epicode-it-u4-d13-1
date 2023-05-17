package entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {
	@Id
	@GeneratedValue
	private UUID id;
	private String name;

	public Category(String name) {
		this.name = name;
	}

	@ManyToMany
	@JoinTable(name = "blogs_categories", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "blog_id"))
	Set<BlogPost> blogs;

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
