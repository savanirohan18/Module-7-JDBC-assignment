//o Write a simple Java program to connect to a MySQL database using JDBC.


package JDBCAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Leb_1_JDBCConnect {

	public static void main(String[] args) throws SQLException 
	{
		try {
			//o Identify which driver your Java program uses to connect to MySQL.
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
			System.out.println("Connection established");
			
			Statement s=c.createStatement();
			
			ResultSet r=s.executeQuery("select * from emp");
			
			while(r.next())
			{
			System.out.println("id"+r.getInt(1));
			System.out.println("name"+r.getString(2));
			System.out.println("age"+r.getInt(3));
			System.out.println();
			}
			c.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
