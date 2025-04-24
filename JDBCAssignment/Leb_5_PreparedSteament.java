//o Modify the program to use PreparedStatement for parameterized queries.

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

class stetament implements ActionListener {
	JFrame frame;
	JLabel l1, l2, l3, msg;
	JTextField t1, t2, t3;
	JButton b1, b2, b3, b4;
	private ResultSet resultSet;

	public stetament() {
		frame = new JFrame("grid Demo");
		frame.setLayout(new GridLayout(6, 2));
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		l1 = new JLabel("enter the id:");
		l2 = new JLabel("enter the name:");
		l3 = new JLabel("enter age age:");
		msg = new JLabel(" ");

		t1 = new JTextField(15);
		t2 = new JTextField(15);
		t3 = new JTextField(15);

		b1 = new JButton("Insert");
		b1.addActionListener(this);
		b2 = new JButton("Update");
		b2.addActionListener(this);
		b3 = new JButton("Delete");
		b3.addActionListener(this);
		b4 = new JButton("Display");
		b4.addActionListener(this);

		frame.add(l1);
		frame.add(t1);
		frame.add(l2);
		frame.add(t2);
		frame.add(l3);
		frame.add(t3);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(msg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			System.out.println("insert");
			try {
				String query = "insert into emp values(?,?,?)";
				PreparedStatement ps = PreparedStatementUtil.getPreparedStatement(query);
				ps.setInt(1, Integer.parseInt(t1.getText()));
				ps.setString(2, t2.getText());
				ps.setInt(3, Integer.parseInt(t3.getText()));

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

		else if (e.getSource() == b2) {
			System.out.println("update");
			try {
				String query = "UPDATE emp SET name = ?,age = ? WHERE id = ?";
				PreparedStatement ps = PreparedStatementUtil.getPreparedStatement(query);
				ps.setString(1, t2.getText());
				ps.setInt(2, Integer.parseInt(t3.getText()));
				ps.setInt(3, Integer.parseInt(t1.getText()));

				int x = ps.executeUpdate();

				if (x > 0) {
					msg.setText("record Updated");
				} else {
					msg.setText("record int Updated");
				}
				ps.close();
				PreparedStatementUtil.closeConnection();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}	
			else if (e.getSource() == b3) {
				System.out.println("delete");
				try {
					String query = "delete from  emp where id = ? ";
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
			else if (e.getSource() == b4) {
			try {
				String query = "select * from emp where id = ?";
				PreparedStatement ps = PreparedStatementUtil.getPreparedStatement(query);
				ps.setInt(1, Integer.parseInt(t1.getText()));

				// Fetch particular record based on the userId from the emp table
				resultSet = ps.executeQuery();

				if (resultSet.next()) {
					String fetchedRecord = "Employee: Id: " + resultSet.getInt(1) + ", Name: " + resultSet.getString(2)
							+ ", Age: " + resultSet.getInt(3);

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
	}
}

public class Leb_5_PreparedSteament {

	public static void main(String[] args) {
		new stetament();
	}

}
