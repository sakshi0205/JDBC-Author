package pack2;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import pack1.Employee;




public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AuthorDao dao=new AuthorDao();
		Scanner sc=new Scanner(System.in);

	
		System.out.println("enter choice");
		int c = sc.nextInt();
		switch(c){
		case 1:
		System.out.println("------Enter Employee Details-------");
		
		System.out.println("Enter author id: ");
		Integer authorId=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter author First Name: ");
		String firstName=sc.next();
		System.out.println("Enter author Middle Name: ");
		String middleName=sc.next();
		sc.nextLine();
		System.out.println("Enter author Last Name: ");
		String lastName=sc.next();
		System.out.println("Enter author phone number: ");
		Integer phoneNo=sc.nextInt();
		
		Author a=new Author();
	    a.setAuthorId(authorId);
	    a.setFirstName(firstName);
	    a.setMiddleName(middleName);
	    a.setLastName(lastName);
	    a.setPhoneNo(phoneNo);
		int rows=dao.addAuthor(a);
		
		System.out.println(rows +" Row Insert Succesfully");
		break;
		

		case 2 :
			
		List<Author> authorList=dao.getAuthor();
		for(Author a1:authorList)
		{
			System.out.println();
		}
		break;
		
		case 3:
			System.out.println("Enter author id: ");
			 authorId=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter employee new phone number: ");
			Integer newphoneNo=sc.nextInt();
			
			rows=dao.updateAuthor(authorId, newphoneNo);
			System.out.println(rows + " Updated successfully");
			break;
		
		case 4:
			System.out.println("Enter author id: ");
			 authorId=sc.nextInt();
			 sc.nextLine();
			 rows=dao.deleteEmployee(authorId);
			 System.out.println(rows + "Deleted successfully");
        }
		System.out.println("Program ends");
       }
	}