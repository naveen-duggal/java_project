package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dao.StudentDao;
import com.spring.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);

          BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
          
          Boolean go = true;
          while(go)
          {
        	  System.out.println("PRESS 1 for add new student");
        	  System.out.println("PRESS 2 for display all students");
        	  System.out.println("PRESS 3 for get detail of single student");
        	  System.out.println("PRESS 4 for delete students");
        	  System.out.println("PRESS 5 for update student");
        	  System.out.println("PRESS 6 for exit");
        	  System.out.println();
        	  try
        	  {
        		  int input = Integer.parseInt(br.readLine());
        		  switch (input) {
				case 1:
					//add a anew student
					//taking input from users
					System.out.println("enter user id : ");
					int uid=Integer.parseInt(br.readLine());
					
					System.out.println("enter user name : ");
					String uName=br.readLine();
					
					System.out.println("enter user city: ");
					String uCity=br.readLine();
					
					//create studnet object and setting values
					Student s = new Student();
					s.setStudentId(uid);
					s.setStudentName(uName);
					s.setStudentCity(uCity);
					
					//saving student object to database by calling insert of student dao
					int r=studentDao.insert(s);
					System.out.println(r + " student added");
					System.out.println("*****************************************");
					System.out.println();
					break;
                
				case 2:
					//display all student
                	List<Student> allStudents = studentDao.getAllStudents();
                	for(Student student : allStudents)
                	{
                		System.out.println("Id : " + student.getStudentId());
                		System.out.println("Name : " + student.getStudentName());
                		System.out.println("City : " + student.getStudentCity());
                	}
                	
                	System.out.println("********************************************");
                	System.out.println();
					break;
                case 3:
					//get single student data
                	System.out.println("Enter user id :");
                	int userId = Integer.parseInt(br.readLine());
                	Student student = studentDao.getStudent(userId);
                	
                	System.out.println("Id : " + student.getStudentId());
            		System.out.println("Name : " + student.getStudentName());
            		System.out.println("City : " + student.getStudentCity());
            		System.out.println("*********************************************");
            		System.out.println();
					break;					
                case 4:
	                //delete the student data
                	System.out.println("Enter user id :");
                	int id = Integer.parseInt(br.readLine());
                	studentDao.deleteStudent(id);
                	System.out.println("student deleted....");
	                break;
                case 5:
	                //update student data
                	System.out.println("Enter user id you want to update :");
                	int sId = Integer.parseInt(br.readLine());
                	
                    Student student1 = studentDao.getStudent(sId);
                	System.out.println("Id : " + student1.getStudentId());
            		System.out.println("Name : " + student1.getStudentName());
            		System.out.println("City : " + student1.getStudentCity());
            		System.out.println();
            		
            		System.out.println("enter new user name : ");
					String name=br.readLine();
					
					System.out.println("enter new user city: ");
					String city=br.readLine();
					
					//create studnet object and setting values
					Student s1 = new Student();
					s1.setStudentName(name);
					s1.setStudentCity(city);
					
					studentDao.updateStudent(s1);
					System.out.println("Student data update successfully...");
            		
                	break;
                case 6:
                	go=false;
                	break;
				
				}
        	  }
        	  catch(Exception e)
        	  {
        		  System.out.println("Invaid input with another one !!");
        		  System.out.println(e.getMessage());
        	  }
          }
          System.out.println("Thank you for using my application");
          System.out.println("see you soon !!");
    }
}
