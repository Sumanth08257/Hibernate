package com.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.dao.CustomerCrud;
import com.dto.Customer;

public class CustomerMain {
	public static void main(String[] args) {
		CustomerCrud cd=new CustomerCrud();
		Customer c=new Customer();
		Scanner val=new Scanner(System.in);
		boolean exit=true;
		int choose;
		
		while(exit) {
			System.out.println("1: save"+"\n2: get customer"+"\n3: delete"+"\n4: update"+"\n5: get all"+"\n6: exit");
			System.out.println("Choose any one");
			choose=val.nextInt();
			switch(choose) {
			
			case 1:{
				System.out.println("Enter the name");
				c.setName(val.next());
				System.out.println("Enter the age");
				c.setAge(val.nextInt());
				System.out.println("Enter the e-mail");
				c.setEmail(val.next());
				System.out.println("Enter the phone number");
				c.setPhone(val.nextLong());
				cd.saveCustomer(c);
			}
			break;
			case 2:{
				System.out.println("Enter the ID");
				int id=val.nextInt();
				cd.getCustomerById(id);
			}
			break;
			case 3:{
				System.out.println("Enter the ID");
				int id=val.nextInt();
				cd.deleteCustomer(id);
				
				
			}
			break;
			case 4:{
				System.out.println("Enter id");
				int id=val.nextInt();
				System.out.println("Enter name that you want change");
				c.setName(val.next());
				cd.updateCustomer(id);
			}
			break;
			case 5:{
				cd.getAllCustomer();
			}
			break;
			case 6:{
				exit=false;
			}
			break;
			default:System.out.println("Please select valid choice");
			
			}
		}
		
		
	}

}
