package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entities.Pizza;
import lombok.extern.slf4j.Slf4j;
import utils.JpaUtil;

@Slf4j
public class Application {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		Pizza margherita = new Pizza();
		margherita.setNome("Margherita");
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(margherita);
		t.commit();
		log.info("Pizza salvata!");

		em.close();
		emf.close();

	}

}
