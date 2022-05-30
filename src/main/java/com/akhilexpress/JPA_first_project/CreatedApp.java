package com.akhilexpress.JPA_first_project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.akhilexpress.entity.Address;
import com.akhilexpress.entity.Student;

public class CreatedApp {

	public static void main(String[] args) {

		// create configuration
	//	SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		EntityManagerFactory entityManagerFactory=null;
		
		Address address=new Address();
		address.setAddressLine1("mig-778");
		address.setAddressLine2("colony");
		address.setCity("Morena");
		
		Student student=new Student();
		student.setName("Akhilesh");
		student.setMobile(74774747);
		student.setAddress(address);
	
	//	Session session = sessionFactory.openSession();
		EntityManager entityManager=null;
		
		
	//	Transaction transaction = session.beginTransaction();
		EntityTransaction transaction=null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("mydatasource");
			 entityManager = entityManagerFactory.createEntityManager();
			  transaction = entityManager.getTransaction();
			
			
			  transaction.begin();
			entityManager.persist(student);
			transaction.commit();
			
		} catch (Exception e) {

				transaction.rollback();
		}
		finally {
			entityManager.close();
			entityManagerFactory.close();
		}

	}
}
