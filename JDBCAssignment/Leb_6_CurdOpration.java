//o Write a Java program that performs the following CRUD operations:
// Insert a new record.
// Update an existing record.
// Select and display records.
// Delete a record from the database.



/*o Implement CRUD operations (Insert, Update, Select, Delete) using JDBC and MySQL.
 
 
o On button clicks, the program should interact with the database and perform the
appropriate operation (insert, update, display records, or delete records).*/

package JDBCAssignment;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.util.PreparedStatementUtil;

class Opration implements ActionListener{
    JFrame frame;
    JLabel l1, l2, l3, l4, l5, msg;
    JTextField t1, t2, t3, t4, t5;
    JButton b1, b2, b3, b4;
	private ResultSet resultSet;

    public Opration() {
        frame = new JFrame("Grid Demo");
        frame.setLayout(new GridLayout(8, 2));
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("ID:");
        l2 = new JLabel("First Name:");
        l3 = new JLabel("Last Name:");
        l4 = new JLabel("Email:");
        l5 = new JLabel("Mobile:");
        msg = new JLabel();

        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);
        t4 = new JTextField(15);
        t5 = new JTextField(15);

        b1 = new JButton("Insert");
        b1.addActionListener(this);
        b2 = new JButton("Search By ID");
        b2.addActionListener(this);
        b3 = new JButton("Update");
        b3.addActionListener(this);
        b4 = new JButton("Delete");
        b4.addActionListener(this);

        frame.add(l1);
        frame.add(t1);
        frame.add(l2);
        frame.add(t2);
        frame.add(l3);
        frame.add(t3);
        frame.add(l4);
        frame.add(t4);
        frame.add(l5);
        frame.add(t5);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(msg);
    }

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == b1) {
			System.out.println("insert");
			try {
				String query = "insert into student1 values(?,?,?,?,?)";
				PreparedStatement ps = PreparedStatementUtil.getPreparedStatement(query);
				ps.setInt(1, Integer.parseInt(t1.getText()));
				ps.setString(2, t2.getText());
				ps.setString(3, t3.getText());
				ps.setString(4, t4.getText());
				ps.setInt(5, Integer.parseInt(t5.getText()));

				int x = ps.executeUpdate();

				if (x > 0) {
					msg.setText("record inserted");

				} else {
					msg.setText("record int inserted");
				}
				ps.close();
				PreparedStatementUtil.closeConnection();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	}
		//o Write a program that executes a SELECT query and processes the ResultSet to
		//display records from the database.
		else if (e.getSource() == b2) {
			try {
				String query = "select * from student1 where id = ?";
				PreparedStatement ps = PreparedStatementUtil.getPreparedStatement(query);
				ps.setInt(1, Integer.parseInt(t1.getText()));

				// Fetch particular record based on the userId from the student1 table
				resultSet = ps.executeQuery();

				if (resultSet.next()) {
					String fetchedRecord = "student1: Id: " + resultSet.getInt(1) + ", firstName: " + resultSet.getString(2)
							+ ", lastname: " + resultSet.getString(3)+ ", emaill: " + resultSet.getString(4)+ ", mobile: " + resultSet.getInt(5);

					// This line Display record in the Screen
					msg.setText(fetchedRecord);
				} else {
					msg.setText("Record Not Found");
				}
				ps.close();
				PreparedStatementUtil.closeConnection();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == b3) {
			System.out.println("update");
			try {
				String query = "UPDATE student1 SET firstname = ?,lastname = ?,email = ?,mobile = ? WHERE id = ?";
				PreparedStatement ps = PreparedStatementUtil.getPreparedStatement(query);
				ps.setString(1, t2.getText());
				ps.setString(2, t3.getText());
				ps.setString(3, t4.getText());
				ps.setInt(4, Integer.parseInt(t5.getText()));
				ps.setInt(5, Integer.parseInt(t1.getText()));

				int x = ps.executeUpdate();

				if (x > 0) {
					msg.setText("record Updated");
				} else {
					msg.setText("record not Updated");
				}
				ps.close();
				PreparedStatementUtil.closeConnection();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}	
		else if (e.getSource() == b4) {
			System.out.println("delete");
			try {
				String query = "delete from  student1 where id = ? ";
				PreparedStatement ps = PreparedStatementUtil.getPreparedStatement(query);
				ps.setInt(1, Integer.parseInt(t1.getText()));

				int x = ps.executeUpdate();

				if (x > 0) {
					msg.setText("record delete");
				} else {
					msg.setText("record not delete");
				}
				ps.close();
				PreparedStatementUtil.closeConnection();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
	} 
}
}
public class Leb_6_CurdOpration {

	public static void main(String[] args) 
	{
		new Opration();
	}
}
