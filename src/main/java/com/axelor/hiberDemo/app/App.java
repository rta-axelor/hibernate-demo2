package com.axelor.hiberDemo.app;

import javax.persistence.*;

import com.axelor.hiberDemo.db.Address;
import com.axelor.hiberDemo.db.ContactNo;
import com.axelor.hiberDemo.db.Email;
import com.axelor.hiberDemo.db.Student;
import com.axelor.hiberDemo.db.Subject;

import java.util.*;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("myJpaUnit");
		EntityManager em = emfactory.createEntityManager();

		create(em);
		read(em);
		update(em);
		// delete(em);
		em.close();
		emfactory.close();

	}

	private static void create(EntityManager em) {
		System.out.println("Creating Student records");

		em.getTransaction().begin();

		Student s1 = new Student();
		// s1.setId(1);
		s1.setName("Rajvi");
		

		Student s2 = new Student();
		// s2.setId(2);
		s2.setName("Rajvi T");
		
	

		Address address1 = new Address();
		address1.setHouseNumber(101);
		address1.setStreet("Kosamba");
		address1.setCity("Valsad");
		address1.setState("Gujarat");
		address1.setZipcode(396001);

		s1.setAddress(address1);
		s2.setAddress(address1);

		ContactNo no1 = new ContactNo(8347454038l);
		ContactNo no2 = new ContactNo(8849016624l);

		s1.setCno(no1);
		s2.setCno(no2);
//		
//		Email email1 = new Email();
//		email1.setEmailid("rajvitandel");
//		email1.setPswd("rajvi");
//		
//		Email email2 = new Email();
//		email2.setEmailid("tandelrajvi");
//		email2.setPswd("tandel");
//		
//		s1.setEmail(email1);
//		s2.setEmail(email2);
		
	//	--------------------------------------------
		Email e1 = new Email();
		e1.setEmailid("rajvitandel");
		e1.setPswd("rajvi");
		s1.addEmailListItem(e1);
//		
//		
//		Subject sub1 = new Subject("Java");
//		s1.setSubject(sub1);
		em.persist(e1);
		em.persist(s1);
		
		em.getTransaction().commit();

	}

	private static void read(EntityManager em) {

		/*
		 * em.getTransaction().begin(); Student s1 = em.find(Student.class, 1l); Student
		 * s2 = em.find(Student.class, 2l); System.out.println(s1.getName());
		 * System.out.println(s2.getName());
		 * 
		 * em.getTransaction().commit();
		 */

		Query q = em.createQuery(" from Student s");

		List<Student> list = q.getResultList();
		Iterator<Student> itr = list.iterator();

		while (itr.hasNext()) {
			Student s1 = itr.next();
			System.out.println("Student ID:" + s1.getId());
			System.out.println("\t Student NAME: " + s1.getName());

			Address address = s1.getAddress();
			System.out.println("\t Address: " + address.getHouseNumber() + address.getStreet() + ", "
					+ address.getCity() + ", " + address.getState() + ", " + address.getZipcode());

			ContactNo cno = s1.getCno();
			System.out.println("\t Student contact number :" + cno.getNumber());

//			Email email =(Email) s1.getEmail();
//			System.out.println("\t Email ID: " + email.getEmailid() + "\t Password: " + email.getPswd());
			
		//------------------------------------------------------------------------------------------	
			
//				 List email =s1.getEmail(); 
//				 for(Iterator itr3 = email.iterator();itr3.hasNext();) { 
//				 Email ema = (Email) itr3.next();
//				 System.out.println("\t Email Id: " + ema.getEmailid());
//				 System.out.println("\t Email Password: " + ema.getPswd());
//			 
//			 }
//			 
			 
			List subjects = s1.getSubject();
			for (Iterator itr3 = subjects.iterator(); itr3.hasNext();) {
				Subject sub = (Subject) itr3.next();
				System.out.println("\t Subject: " + sub.getSname());
			}
		}
	}

	private static void update(EntityManager em) {
		System.out.println("Updating record");

		em.getTransaction().begin();

		Student existingUser = new Student();

		existingUser.setId(2l);
		existingUser.setName("Rajvi Tandel");

		em.merge(existingUser);

		em.getTransaction().commit();

	}

	private static void delete(EntityManager em) {

		Student student = em.find(Student.class, 1);

		em.getTransaction().begin();
		em.remove(student);
		em.getTransaction().commit();

	}

}
