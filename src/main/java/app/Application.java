package app;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.BlogsDAO;
import dao.CategoriesDAO;
import dao.DocumentsDAO;
import dao.UsersDAO;
import entities.BlogPost;
import entities.Category;
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
		CategoriesDAO cd = new CategoriesDAO(em);

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
		// Torna tutti i blog scritti da user Aldo (found)
		found.getBlogPosts().stream().forEach(b -> log.info(b.toString()));

		// ********************** Many to Many ***********************
		// cd.insertMany(new HashSet<>(Arrays.asList("Java", "Backend", "Frontend",
		// "React", "CSS")));

		Category backendCategory = cd.findById("8a611d97-3890-4e2a-9ce0-3ebdafebfbde");
		Category javaCategory = cd.findById("79b429f5-083a-4046-8cec-6c735dc2a52e");
		if (backendCategory != null && javaCategory != null) {
			java2.setCategories(new HashSet<>(Arrays.asList(backendCategory, javaCategory)));
			// bd.saveBlog(java2);
		}
		// torna tutte le categorie di cui il blog java2 fa parte
		java2.getCategories().stream().forEach(c -> log.info(c.toString()));

		// torna tutti i blog facenti parte della categoria backend
		backendCategory.getBlogs().stream().forEach(b -> log.info(b.toString()));

		em.close();
		emf.close();

	}

}
