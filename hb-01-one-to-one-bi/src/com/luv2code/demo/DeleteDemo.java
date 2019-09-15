package com.luv2code.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		//create Session factory
		
		SessionFactory factory=new Configuration()
									.configure()
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									  .buildSessionFactory();
		
		//create session
		
		Session session=factory.getCurrentSession();
		
		try {
			
					
			
			//start the transaction
			session.beginTransaction();
			
			//get Instructor by primary key
			
			int theId=1;
			
			Instructor tempInstructor=session.get(Instructor.class,theId);
			
			System.out.println("Found Instructor : "+ tempInstructor);
			
			
			//delete the instructor
			
			//will also delete details instructor due to CascadeTYpe All
			
			if(tempInstructor!=null)
			{
				System.out.println("Deleting Instructor : "+ tempInstructor);
				
				session.delete(tempInstructor);
				
			}
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!");
			
			
			
			
		}
		
		finally {
			
			factory.close();
		}
									

	}

}
