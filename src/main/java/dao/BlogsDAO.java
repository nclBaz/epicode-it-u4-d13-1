package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.BlogPost;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlogsDAO {
	private final EntityManager em;

	public BlogsDAO(EntityManager em) {
		this.em = em;
	}

	public void saveBlog(BlogPost b) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(b);
		t.commit();
		log.info("Blog salvato!");
	}

	public BlogPost findById(String id) {
		BlogPost found = em.find(BlogPost.class, UUID.fromString(id));
		return found;
	}
}
