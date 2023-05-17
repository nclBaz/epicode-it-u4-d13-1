package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UsersDAO {
	private final EntityManager em;

	public UsersDAO(EntityManager em) {
		this.em = em;
	}

	public void saveUser(User u) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(u);
		t.commit();
		log.info("Utente salvato!");
	}

	public User findById(String id) {
		User found = em.find(User.class, UUID.fromString(id));
		return found;
	}

}
