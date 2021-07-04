package airline;


	import java.util.*;
	import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

	class project 
	{

	    String name,password,email,address;
	    int age,phone;
	   
	Scanner s=new Scanner(System.in);
	     
	    public void register()
	   {
	        try
	  {
	        	Class.forName("com.mysql.jdbc.Driver");  
	        	Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/prodapt","root","system");  
	        	
	        	PreparedStatement ps=con.prepareStatement("INSERT INTO login(name,password,email,address,age,phone) VALUES(?,?,?,?,?,?)");	
	        	 
	     System.out.println("enter ur details for register");
	       System.out.println("enter name");
	        name = s.next();
	           
	     System.out.println("enter password");
	            password=s.next();
	            
	       System.out.println("enter emailid");
	           email=s.next();
	           
	     System.out.println("enter address");
	           address=s.next();
	            
	           System.out.println("enter age");
	              age= s.nextInt();
	               
	             System.out.println("enter phone");
	                   phone=s.nextInt();
	                   
	              ps.setString(1, name);
	              ps.setString(2, password);
	              ps.setString(3, email);
	              ps.setString(4, address);
	              ps.setInt(5,age);
	              ps.setInt(6, phone);
	              ps.executeUpdate();
	              con.close();
	       System.out.println("registered succefully");
	        System.out.println("thank you");
	           
	       
	}
	catch(Exception e){}
	    }
	  

	    public void login()
	   {
	     try
	  {
	    	 Class.forName("com.mysql.jdbc.Driver");  
	        	Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/prodapt","root","system");  
	        	PreparedStatement  ps=con.prepareStatement("select password from login where name=(?)");
	        	System.out.println("enter username");
	                String username= s.next();
	                ps.setString(1,username);
	             
	                boolean br= ps.execute();
	                if(br)
	                {
	                	ResultSet rs= ps.getResultSet();
	                   while(rs.next())
	                {
	                	
	                String password1= rs.getString(1);
	            System.out.println("enter password");
	          String   userpassword=s.next();
	           if(  userpassword.equals(password1))
	             {
	        	   do 
	        	   {
	        		System.out.println("1.Booking  \n 2.booking History");
	              System.out.println("enter ur choice");
	               booking b= new booking();
	               int c1=s.nextInt();
	                 switch(c1)
	                   {
	                      case 1: b.from();
	                               b.to();
	                               b.date();
	                               b.flight();
	                               b.jdbc();
	                               b.confirmation();
	                                break;
	                        case 2: System.out.println("1.previous bookng   \n2.postphone  \n3.cancelticket ");
	                                 System.out.println("enter ur choice");
	                                  int c2= s.nextInt();
	                                  switch(c2) 
	                                   {
	                                      case 1: b.previous();
	                                                break;
	                                       case 2: b.postpone();
	                                                break;
	                                        case 3: b.cancel();
	                                                 break;
	                                     }
	                       }
	                       System.out.println("if you want to continue or exit ");
	                       System.out.println("1.continue \n 2.eixt");
	                       String sname=s.next();
	                       if(sname.equals("exit"))
	                       {
	                    	   break;
	                       }
	                       
	        	   }while(true);
	        	  
	              }
	              else
	        {
	        System.out.println("username and password mismatch");
	           }
	                }
	                }
	             
	              con.close();
	}
	catch(Exception e){}


	     }
	  
	    

	}


