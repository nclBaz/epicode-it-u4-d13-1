package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Document;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DocumentsDAO {
	private final EntityManager em;

	public DocumentsDAO(EntityManager em) {
		this.em = em;
	}

	public void saveDocument(Document u) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(u);
		t.commit();
		log.info("Documento salvato!");
	}

	public Document findById(String id) {
		Document found = em.find(Document.class, UUID.fromString(id));
		return found;
	}
}
