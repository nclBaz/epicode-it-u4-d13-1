package dao;

import java.util.Set;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Category;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CategoriesDAO {
	private final EntityManager em;

	public CategoriesDAO(EntityManager em) {
		this.em = em;
	}

	public void saveCategory(Category c) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(c);
		t.commit();
		log.info("Categoria salvata!");
	}

	public Category findById(String id) {
		Category found = em.find(Category.class, UUID.fromString(id));
		return found;
	}

	public void insertMany(Set<String> categories) {
		for (String c : categories) {
			EntityTransaction t = em.getTransaction();
			Category newCategory = new Category(c);
			t.begin();
			em.persist(newCategory);
			t.commit();
		}
		log.info("Categorie salvate!");
	}
}
