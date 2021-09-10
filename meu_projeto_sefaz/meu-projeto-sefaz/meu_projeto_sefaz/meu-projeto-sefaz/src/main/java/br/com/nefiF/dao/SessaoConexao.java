package br.com.nefiF.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessaoConexao {
	
	public static SessionFactory getConnection() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SefazPU");
		EntityManager entityManager = emf.createEntityManager();
		Session session = entityManager.unwrap(org.hibernate.Session.class);
		SessionFactory factory = session.getSessionFactory();
		
		return factory;
		
	}

}
