//o Demonstrate the process of loading a JDBC driver and establishing a connection.

//o Identify which driver your Java program uses to connect to MySQL

package JDBCAssignment;

import java.sql.Connection;
import java.sql.DriverManager;

public class Leb_2_LoadConnection {

	public static void main(String[] args) 
	{
		try {
			//o Research and explain the best JDBC driver for your database and Java environment
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
			System.out.println("Connection established");
			
			c.close();
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
