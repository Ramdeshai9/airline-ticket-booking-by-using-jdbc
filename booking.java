package airline;

     import java.util.*;
	import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
	class booking 
	{
	 String from,to,date,air,broad,depart;
	 int price;
	   Scanner s= new Scanner(System.in);
		public void from()
	{
	
	   System.out.println("enter starting place");
	    System.out.println(" 1. Hyderabad \n2.banglore  \n3.chennai \n4.dehli \n5.mumbai");
	    System.out.println("enter ur choice");
	               int c1=s.nextInt();
	    switch(c1)
	{
	   case 1: from="Hyderabad";
	             
	             break;
	     case 2: from ="Banglore";
	              
	             break;
	 case 3:  from = "Chennai";
	              
	             break;
	 case 4:  from= "Delhi";
	              
	             break;
	 case 5:  from="Mumbai";
	               
	             break;
	}
	}
	
	 public void to()
	{
	
	  System.out.println("enter Destination place");
	    System.out.println(" 1.Maldives \n2.London  \n3.Dubai \n4.Newyork \n5.Melbourne");
	    System.out.println("enter ur choice");
	          int c2=s.nextInt();
	      switch(c2)
	      {
	  case 1:  to="Maldives";
	             break;
	     case 2: to= "London";
	             break;
	 case 3: to= " Dubai";
	             break;
	 case 4: to= "Newyork";
	             break;
	 case 5: to="Melbourne";
	             break;
	}
	
	  }
	 public void date()
	{
	 
	       System.out.println("enter date of travelling");
	       date= s.next();
	      
	
	}
	   
	 public void flight()
	{
	
	    
	     System.out.println("choice ur reqiured flights");
	     System.out.println(" 1.airindia  bording time : 6:30    depature time : 13:30 \n 2.Emirates  bording time : 8:30    depature time : 16:30   \n 3.Indigo Airlines   bording time : 10:30    depature time : 18:30 \n 4.Air Asia\tbording time : 14:30\tdepature time : 22:45  \n  5.Spicejet\tbording time : 19:30\tdepature time : 03:30 ");
	      System.out.println("enter ur choice");
	          int c3=s.nextInt();
	      switch(c3)
	      {
	  case 1: air ="Airindia Airlines";
	          broad= " time : 6:30 ";
	          depart=" time : 13:30 ";
	      	    price= 35000;
	          
	             break;
	     case 2: air="Emirates Airline";
	           broad=" time : 8:30  ";
	           depart= " time : 16:30 ";
	           price= 45000;
	             break;
	 case 3: air="Indigo Airlines";
	           broad="  time : 10:30";
	           depart=" time : 18:30";
	           price= 38000;
	             break;
	 case 4:  air="Air Asia Airlines";
	           broad="time : 14:30 ";
	           depart= "  time : 22:45";
	           price= 22000 ;
	             break;
	 case 5: air="Spicejet Airlines";
	           broad="  time : 19:30 ";
	           depart=" time : 03:30 ";
	           price=29000 ;
	             break;
	      }
	}
public void jdbc()
{
	 try
	 {
		
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/prodapt","root","system");  
				PreparedStatement pst1=con.prepareStatement("INSERT INTO booking1(from1,to1,journerydate,air1,board1,depart1,price1)VALUES(?,?,?,?,?,?,?)"); 
				  System.out.println(from);
				 pst1.setString(1,from);
				 pst1.setString(2,to);
				 pst1.setString(3,date);
				 pst1.setString(4,air);
				 pst1.setString(5,broad);
				 pst1.setString(6,depart);
				 pst1.setInt(7,price);
				 int i=pst1.executeUpdate();
				 System.out.println(i);
				 pst1.close();
				con.close();  
				}catch(Exception e){ System.out.println(e);}  
				
	
}
	public void confirmation()
	{
	   try
	{
		   System.out.println("details");
		   Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/prodapt","root","system");  
			 
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from login ");  
			while(rs.next()) 
			{

				//System.out.println(rs.getInt(1));
				System.out.print("name: ");
				System.out.print(rs.getString(2));
				System.out.println(rs.getString(3));
				//System.out.println(rs.getString(4));
				//System.out.println(rs.getString(5));
				
                System.out.print("age: ");
				System.out.println(rs.getInt(6));
				System.out.print("phone: ");
				System.out.println(rs.getInt(7));
			//System.out.println(rs.getInt(1)+"name: "+rs.getString(2)+rs.getString(3)+" \n email: "+rs.getString(4)+"\n address: "+rs.getInt(5)+"\n age: "+rs.getInt(6)+"\n phoine: "+rs.getInt(7));
			}
			  
	   
	       

	
		  
			 
			Statement stmt1=con.createStatement();  
			ResultSet r=stmt1.executeQuery("select * from booking1");  
			while(r.next())
			{
				System.out.print("from: ");
				System.out.println(r.getString(2));
				System.out.print("to: ");
				System.out.println(r.getString(3));
				System.out.print("company name: ");
				System.out.println(r.getString(4));
				System.out.print("boarding ");
				System.out.println(r.getString(5));
				System.out.print("depacture ");
				System.out.println(r.getString(6));
				System.out.print("date of travelling :");
				System.out.println(r.getString(7));
				System.out.print("price");
				System.out.println(r.getInt(8));
			//System.out.println(r.getInt(1)+ "starting form: "+r.getString(2)+"\n to distination: "+r.getString(3)+"\n date of travelling: "+r.getInt(4)+"\n airline name: "+r.getString(5)+"\n boarding "+r.getString(6)+"\n depacture "+r.getString(7)+" \n price of ticket:"+r.getInt(8));  
			}
			con.close();  
	   
	}
	catch(Exception e){}

	   System.out.println("check ur details \n if all details  correct enter : 1.yes \n if any details are wrong enter : 2.no ");
	  System.out.println("enter ur choice");
	    int  c4=s.nextInt();
	    switch(c4)
	     {
	      case 1:   System.out.println("enter  payment details");
	                 System.out.println(" 1.debit cards \n 2.credit cards \n 3.upi");
	                  System.out.println("enter ur payments option");
	                  int c5=s.nextInt();
	                   switch(c5)
	                    {
	                      case 1: System.out.println("enter ur debit cards details");
	                              System.out. println("enter ur cards details");
	                                String s2=s.next();
	                               System.out.println(" Enter last four digits of cards");
	                                String s3=s.next();
	                              System.out.println("enter cards expire date");
	                                 String s4= s.next();
	                                System.out.println("  processing...!");
	                                
	                                    try
	                                      {
	                                   Thread.sleep(5000);
	                                       }
	                                       catch(Exception e){}
	                                   
	                                  System.out.println("payment sucessfull..!");
	                                   System.out.println("ticket booked");
	                                    break;
	                        case 2: System.out.println("enter ur credit cards details");
	                              System.out. println("enter ur cards details");
	                                String s5=s.next();
	                               System.out.println(" Enter last four digits of cards");
	                                String s6=s.next();
	                              System.out.println("enter cards expire date");
	                                 String s7= s.next();
	                                System.out.println("  processing...!");
	                                
	                                    try
	                                      {
	                                   Thread.sleep(5000);
	                                       }
	                                       catch(Exception e){}
	                                
	                                    
	                                  System.out.println("payment sucessfull..!");
	                                   System.out.println("ticket booked");
	                                    break;
	                             case 3: System.out.print("enter upi details");
	                                     System.out.print("enter ur mobline number");
	                                     String s8=s.next();
	                                     System.out.println("enter six digit pin code sent to mobile no"); 
	                                      String s9=s.next();
	                                       System.out.println("  processing...!");
	                                
	                                    try
	                                      {
	                                   Thread.sleep(5000);
	                                       }
	                                       catch(Exception e){}
	                            
	                                     
	                                  System.out.println("payment sucessfull..!");
	                                   System.out.println("ticket booked");
	                                       break;
	                    }
	                                       break;
	        case 2: System.out.println("edit onceagain");
	                 System.exit(0);
	                  break;
	  }   

	     }
	 public void previous()
	{
	 System.out.println(" perviously booked flight ticket details");
	  try
		{
		  System.out.println("details");
		   Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/prodapt","root","system");  
			 
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from login ");  
			while(rs.next()) 
			{
                System.out.print("name: ");
				System.out.print(rs.getString(2));
				System.out.println(rs.getString(3));
			     System.out.print("age: ");
				System.out.println(rs.getInt(6));
				System.out.print("phone: ");
				System.out.println(rs.getInt(7));
			
			}
			 Statement stmt1=con.createStatement();  
			ResultSet r=stmt1.executeQuery("select * from booking1");  
			while(r.next())
			{
				System.out.print("from: ");
				System.out.println(r.getString(2));
				System.out.print("to: ");
				System.out.println(r.getString(3));
				System.out.print("company name: ");
				System.out.println(r.getString(4));
				System.out.print("boarding ");
				System.out.println(r.getString(5));
				System.out.print("depacture ");
				System.out.println(r.getString(6));
				System.out.print("date of travelling :");
				System.out.println(r.getString(7));
				System.out.print("price");
				System.out.println(r.getInt(8));
			//System.out.println(r.getInt(1)+ "starting form: "+r.getString(2)+"\n to distination: "+r.getString(3)+"\n date of travelling: "+r.getInt(4)+"\n airline name: "+r.getString(5)+"\n boarding "+r.getString(6)+"\n depacture "+r.getString(7)+" \n price of ticket:"+r.getInt(8));  
			}
			con.close();  
	   		}
	 catch(Exception e){}
	}
	 public void cancel()
	{
	  try
	{
		  Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/prodapt","root","system");  
	 Statement stmt1=con.createStatement();  
		ResultSet r=stmt1.executeQuery("select * from booking1");  
		while(r.next())
		{
			System.out.print( "id :");
			System.out.println(r.getInt(1));
			System.out.print("from: ");
			System.out.println(r.getString(2));
			System.out.print("to: ");
			System.out.println(r.getString(3));
			System.out.print("company name: ");
			System.out.println(r.getString(4));
			System.out.print("boarding ");
			System.out.println(r.getString(5));
			System.out.print("depacture ");
			System.out.println(r.getString(6));
			System.out.print("date of travelling :");
			System.out.println(r.getString(7));
			System.out.print("price :");
			System.out.println(r.getInt(8));
		}
	 System.out.println("enter the id of booking which u want to cancel");
	 int eid=s.nextInt();
	
        PreparedStatement pst1=con.prepareStatement("delete from booking1 where id=(?)");
        pst1.setInt(1, eid);
        pst1.executeUpdate();
        System.out.println("flight ticket cancelled successfully");
        con.close();
	}
	catch(Exception e){}
	}
	public void postpone()
	{
		try
		{
		  Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/prodapt","root","system");  
			Statement stmt1=con.createStatement();  
			ResultSet r=stmt1.executeQuery("select * from booking1");  
			while(r.next())
			{
				System.out.print( "id :");
				System.out.println(r.getInt(1));
				System.out.print("from: ");
				System.out.println(r.getString(2));
				System.out.print("to: ");
				System.out.println(r.getString(3));
				System.out.print("company name: ");
				System.out.println(r.getString(4));
				System.out.print("boarding ");
				System.out.println(r.getString(5));
				System.out.print("depacture ");
				System.out.println(r.getString(6));
				System.out.print("date of travelling :");
				System.out.println(r.getString(7));
				System.out.print("price :");
				System.out.println(r.getInt(8));
			}
			
			 System.out.println("enter the id of booking which u want to postpone");
			 int eid=s.nextInt();
			 System.out.println("enter new date of travelling");
		        String date2= s.next();
		        PreparedStatement pst1=con.prepareStatement("update booking1 set journerydate=(?) where id=(?)");
		        pst1.setString(1, date2);
		        pst1.setInt(2, eid);
		        pst1.executeUpdate();
		        Statement stmt=con.createStatement();  
				ResultSet r1=stmt.executeQuery("select * from booking1");  
				while(r1.next())
				{
					System.out.print( "id :");
					System.out.println(r1.getInt(1));
					System.out.print("from: ");
					System.out.println(r1.getString(2));
					System.out.print("to: ");
					System.out.println(r1.getString(3));
					System.out.print("company name: ");
					System.out.println(r1.getString(4));
					System.out.print("boarding ");
					System.out.println(r1.getString(5));
					System.out.print("depacture ");
					System.out.println(r1.getString(6));
					System.out.print("date of travelling :");
					System.out.println(r1.getString(7));
					System.out.print("price :");
					System.out.println(r1.getInt(8));
				}
		       System.out.println("flight ticket is postponed");
		       con.close();
	}
catch(Exception e){}
	
	}

	}




