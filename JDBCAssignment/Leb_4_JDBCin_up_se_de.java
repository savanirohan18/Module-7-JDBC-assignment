//o Create a program that inserts, updates, selects, and deletes data using Statement.
/*o Write SQL queries for:
 Inserting a record into a table.
 Updating specific fields of a record.
 Selecting records based on certain conditions.
 Deleting specific records.*/

package JDBCAssignment;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class simple implements ActionListener
{
	JFrame frame;
	JLabel l1,l2,l3,l4,msg;
	JTextField t1,t2,t3;
	JPasswordField p1;
	JButton b1,b2,b3,b4;
	
	public simple()
	{
		frame=new JFrame("grid Demo");
		frame.setLayout(new GridLayout(7,2));
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l1=new JLabel("enter the firstname:");
		l2=new JLabel("enter the lastname:");
		l3=new JLabel("enter Username:");
		l4=new JLabel("enter password:");
		msg=new JLabel(" ");

		t1=new JTextField(15);
		t2=new JTextField(15);
		t3=new JTextField(15);
		p1=new JPasswordField(15);
		
		b1=new JButton("Insert");
		b1.addActionListener(this);
		b2=new JButton("Update");
		b2.addActionListener(this);
		b3=new JButton("Delete");
		b3.addActionListener(this);
		b4=new JButton("Display");
		b4.addActionListener(this);
		
		frame.add(l1);
		frame.add(t1);
		frame.add(l2);
		frame.add(t2);
		frame.add(l3);
		frame.add(t3);
		frame.add(l4);
		frame.add(p1);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(msg);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==b1)
		{
			System.out.println("insert");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
				System.out.println("Connection established");
				
				Statement st=cn.createStatement();
				PreparedStatement ps = cn.prepareStatement("insert into student values(?,?,?,?)");
				ps.setString(1,t1.getText());
				ps.setString(2,t2.getText());
				ps.setString(3,t3.getText());
				ps.setString(4,p1.getText());
			
//				int x=st.executeUpdate("insert into student values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+p1.getText()+"')");
				
				int x = ps.executeUpdate();
				
				if(x>0)
				{
					msg.setText("record inserted");
					
				}
				else
				{
					msg.setText("record int inserted");
				}
				cn.close();
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if(e.getSource()==b2)
		{
			System.out.println("update");
			try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
			System.out.println("Connection established");
			
			Statement st=cn.createStatement();
		
		
			int x=st.executeUpdate("update student set Fristname='"+t1.getText()+"',Lastname='"+t2.getText()+"',Password='"+p1.getText()+"'where Username='"+t3.getText()+"'");
			
			if(x>0)
			{
				msg.setText("record inserted");
			}
			else
			{
				msg.setText("record int inserted");
			}
			cn.close();
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
		else if(e.getSource()==b3)
		{
			System.out.println("delete");
			try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
			System.out.println("Connection established");
			
			Statement st=cn.createStatement();

		
			int x=st.executeUpdate("delete from student where username='"+t3.getText()+"'");
			
			
			if(x>0)
			{
				msg.setText("record delete");
			}
			else
			{
				msg.setText("record not delete");
			}
			cn.close();
			
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
		else if(e.getSource()==b4)
		{
			System.out.println("select");
			try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
			System.out.println("Connection established");
			
			Statement st=cn.createStatement();
			
			ResultSet rs=st.executeQuery("select * from student");
		//	String result = "User Details:\n";
			while(rs.next())
			{
				System.out.println("Firstname"+rs.getString(1));
				System.out.println("Lasttname"+rs.getString(2));
				System.out.println("Username"+rs.getString(3));
				System.out.println("Password"+rs.getString(4));
				System.out.println();
		//		result += "FirstName: "+rs.getString(1)+"  LastName: "+rs.getString(2)+"  UserName: "+rs.getString(3)+"  Password:"+rs.getString(4)+"          ";
			}
		//	msg.setText(result);
			cn.close();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	}
}

public class Leb_4_JDBCin_up_se_de {

	public static void main(String[] args) 
	{
		new simple(); 
	}

}
