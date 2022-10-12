package com.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonPanMain {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("sks");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction(); 
		Pan pan=new Pan();
		Person person=new Person();
		pan.setNumber("mxlps1679c");
		pan.setAddr("mys");
		person.setName("sks");
		person.setEmail("sks@gmail.com");
		person.setAge(22);
		person.setPan(pan);
		entityTransaction.begin();
		entityManager.persist(pan);
		entityManager.persist(person);
		entityTransaction.commit();
		
	}

}
