package com.luv2code.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.demo.entity.Instructor;
import com.luv2code.demo.entity.InstructorDetail;
import com.luv2code.demo.entity.Student;

public class CreateDemo {

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
			
		/*	//create the object
			
			Instructor tempInstructor=new Instructor("Amitesh","Shama","amiteshsharma77@gmail.com");
			
			InstructorDetail tempInstructorDetail=new InstructorDetail("www.google.com","Cricket");
			
			*/
			
			
			//create the object
			
			Instructor tempInstructor=new Instructor("Piu","Shama","piu77@gmail.com");
			
			InstructorDetail tempInstructorDetail=new InstructorDetail("www.yahoo.com","IAS");
			
			
			
			
			
			
			//associate the object
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			
			
			//start the transaction
			session.beginTransaction();
			
		
			//save instructor
			//This will save details also because of cascading ALL
			
			System.out.println("Saving instructor :" +tempInstructor);
			session.save(tempInstructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!!!");
			
			
			
			
		}
		
		finally {
			
			factory.close();
		}
									

	}

}
