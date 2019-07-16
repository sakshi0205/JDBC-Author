package pack2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pack1.Employee;

public class AuthorDao {
	Connection con=null;
	int rows=0;

	public Integer addAuthor(Author a) throws ClassNotFoundException, SQLException
	{
		try{
			
		Class.forName("com.mysql.jdbc.Driver"); 
		System.out.println("load driver");
		con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/demodb","root","root");
		System.out.println("establish connection");
		
		Statement s=con.createStatement();
		String sql="insert into author values("+a.getAuthorId()+",'"+a.getFirstName()+"','"+a.getMiddleName()+"','"+a.getLastName()+"',"+a.getPhoneNo()+");";
		rows=s.executeUpdate(sql);
	}
	catch(SQLException e1)
	{
		throw e1;
	}
	finally
	{
		if(con!=null)
			try{
				con.close();
			}
		catch(SQLException e2)
		{
			
		}
	}
	return rows;
}
	public List<Author> getAuthor() throws ClassNotFoundException, SQLException
	{
		List<Author> authorList=new ArrayList<>();
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("load driver");
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/demodb","root","root");
			System.out.println("establish connection");
			
			Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("Select authorId,firstName,middleName,lastName,phoneNo from author");
		
			while(rs.next())
			{
				int authorId=rs.getInt("authorId");
				String firstName=rs.getString("firstName");
				String middleName=rs.getString("middleName");
				String lastName=rs.getString("lastName");
				int phoneNo=rs.getInt("phoneNo");
				
				Author a=new Author();
			    a.setAuthorId(authorId);
			    a.setFirstName(firstName);
			    a.setMiddleName(middleName);
			    a.setLastName(lastName);
			    a.setPhoneNo(phoneNo);
				
				
				System.out.println("Author Id: "+rs.getInt("authorId"));
				System.out.println("Author First Name: "+rs.getString("firstName"));
				System.out.println("Author Middle Name:  "+rs.getString("middleName"));
				System.out.println("Author Last Name : "+rs.getString("lastName"));
				System.out.println("Authors phone number: "+rs.getInt("phoneNo"));
				System.out.println();
				
			}}
			catch(SQLException e3)
			{
				throw e3;
			}
			finally
			{
				if(con!=null)
					try{
						con.close();
					}
				catch(SQLException e2)
				{
					
				}
			}
			return authorList;
		}
	
public Integer updateAuthor(Integer authorId,Integer newphoneNo) throws ClassNotFoundException, SQLException
	
	{
		int rows=0;
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("load driver");
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/demodb","root","root");
			System.out.println("establish connection");
			
			Statement s=con.createStatement();
			
		    rows=s.executeUpdate("Update author set phoneNo="+newphoneNo +" where authorId ="+authorId);
			
	}
		catch(SQLException e3)
		{
			throw e3;
		}
		finally
		{
			if(con!=null)
				try{
					con.close();
				}
			catch(SQLException e2)
			{
				
			}
		}
		return rows;
		
	}
public Integer deleteEmployee(Integer authorId) throws ClassNotFoundException, SQLException
{
	int rows=0;
	try{
		Class.forName("com.mysql.jdbc.Driver"); 
		System.out.println("load driver");
		con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/demodb","root","root");
		System.out.println("establish connection");
		
		Statement s=con.createStatement();
		
	    rows=s.executeUpdate("Delete from author  where authorId ="+authorId);
		
}
	catch(SQLException e3)
	{
		throw e3;
	}
	finally
	{
		if(con!=null)
			try{
				con.close();
			}
		catch(SQLException e2)
		{
			
		}
	}
	return rows;
	
}
	}

