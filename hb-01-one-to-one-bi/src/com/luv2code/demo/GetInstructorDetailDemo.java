package com.luv2code.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Student;

public class GetInstructorDetailDemo {

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
			
			
			//get the instructor detail object
			
			int theId=200;
			
			InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class,theId);
			
			
			
			//print the instructor detail
			System.out.println("tempInstructorDetail  :"+tempInstructorDetail);
			
			//print the associated instructor
			
			System.out.println("The associated instructor  :"+tempInstructorDetail.getInstructor());
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!");
		}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		finally {
			session.close();
			factory.close();
		}
									

	}

}
