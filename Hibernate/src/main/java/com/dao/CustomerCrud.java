package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Customer;

public class CustomerCrud { 
	
	
	public EntityManager Entity() {
		EntityManagerFactory ns=Persistence.createEntityManagerFactory("sks");
		EntityManager em=ns.createEntityManager();
		return em;
		
	}
	public void saveCustomer(Customer c1) {
	
		EntityManager entityManager=Entity();
		entityManager.getTransaction().begin();
		entityManager.persist(c1);
		entityManager.getTransaction().commit();
	}
	public void getCustomerById(int id) {
		EntityManager entityManager=Entity();
		Customer cm=entityManager.find(Customer.class, id);
		if(cm!=null) {
			System.out.println(cm);
		}
		else {
			System.out.println("Customer not found with that ID");
		}
	}
	
	public void deleteCustomer(int id) {
		EntityManager entityManager=Entity();
		Customer cm=entityManager.find(Customer.class, id);
		if(cm!=null) {
			
			entityManager.getTransaction().begin();
			entityManager.remove(cm);
			entityManager.getTransaction().commit();
		}
		else {
			System.out.println("Customer not found with that ID");
		}
		
	}
	public void updateCustomer(int id) {
		EntityManager entityManager=Entity();
		Customer cm=entityManager.find(Customer.class, id);
		if(cm!=null) {
			entityManager.getTransaction().begin();
			entityManager.merge(cm);
			entityManager.getTransaction().commit();		}
	
	else {
		System.out.println("Customer not found");
	}
	}
	
	public void getAllCustomer() {
		EntityManager entityManager=Entity();
		Query query=entityManager.createQuery("from Customer");
		List<Customer>customers=query.getResultList();
		for(Customer customer:customers) {
			System.out.println(customer);
		}
	}

}
