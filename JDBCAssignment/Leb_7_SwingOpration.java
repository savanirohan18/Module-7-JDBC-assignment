package JDBCAssignment;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Swingdemo
{
	JFrame frame;
	JLabel l1, l2, l3,l4;
	JTextField t1, t2, t3,t4;
	
	public Swingdemo()
	{
		frame = new JFrame("grid Demo");
		frame.setLayout(new GridLayout(4, 2));
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		l1 = new JLabel("enter the id:");
		l2 = new JLabel("enter the firstname:");
		l3 = new JLabel("enter the lastname:");
		l4 = new JLabel("enter the email");
		
		t1 = new JTextField(15);
		t2 = new JTextField(15);
		t3 = new JTextField(15);
		t4 = new JTextField(15);
		
		
		frame.add(l1);
		frame.add(t1);
		frame.add(l2);
		frame.add(t2);
		frame.add(l3);
		frame.add(t3);
		frame.add(l4);
		frame.add(t4);
		
	}
}
public class Leb_7_SwingOpration {

	public static void main(String[] args)
	{
		new Swingdemo();
	}

}
