package airline;

import java.util.Scanner;

public class airline {
	public static void main(String[] args) throws Exception
	{
		System.out.println("welcome to airticket booking app");
      
  project p=new project();

    Scanner s=new Scanner(System.in);
    boolean b=true;
    int c,i=0;
     do{
        System.out.println(" 1.register  \n2.login");
           System.out.println(" enter ur choice");
            c=s.nextInt();
          switch(c)
          {
            case 1:  p.register();
                        break;
           case 2:   p.login();
                       
                        break;
          }

         }while(b);
	}
}
