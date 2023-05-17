package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.BlogsDAO;
import dao.DocumentsDAO;
import dao.UsersDAO;
import entities.BlogPost;
import entities.Document;
import entities.User;
import lombok.extern.slf4j.Slf4j;
import utils.JpaUtil;

@Slf4j
public class Application {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		UsersDAO ud = new UsersDAO(em);
		DocumentsDAO dd = new DocumentsDAO(em);
		BlogsDAO bd = new BlogsDAO(em);

		// ************************* 1 to 1 **********************
		Document aldoDoc = new Document(LocalDate.now(), "saodijoj2", "IT");
		// dd.saveDocument(aldoDoc);
		User aldo = new User("Aldo", "Baglio", 20, "Italy");
		aldo.setDocument(aldoDoc);

		// ud.saveUser(aldo);
		User found = ud.findById("0edc413b-8cae-45e6-8919-afc7ef54f1d2");
		if (found != null) {
			log.info(found.toString());
		}

		// ********************** 1 to Many ***********************
		if (found != null) {
			BlogPost java = new BlogPost("JPA", "bellissimo", found);
			// bd.saveBlog(java);
		}

		BlogPost java2 = bd.findById("4140d0e4-32c3-4198-9494-96f831f647ec");
		log.info(java2.toString());
		log.info(java2.getUser().toString());

		em.close();
		emf.close();

	}

}
