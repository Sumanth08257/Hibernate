package com.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.dto.Stud;

public class StudCRud {
	public static void  main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("sks");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Stud a=new Stud();
		a.setName("NayanaSumanth");
		a.setLang("Kannada");
		et.begin();
		em.persist(a);
		et.commit();
		
	}
}
