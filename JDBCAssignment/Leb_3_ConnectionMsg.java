//o Write a Java program to establish a connection to a database and print a
//confirmation message upon successful connection.

package JDBCAssignment;

import java.sql.Connection;
import java.sql.DriverManager;

public class Leb_3_ConnectionMsg {

	public static void main(String[] args) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
			System.out.println("successfuly connection");
			
			c.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
