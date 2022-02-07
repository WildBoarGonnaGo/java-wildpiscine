import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class BorderLayoutTrain {
	public static void main(String[] args) {
		/*Layout manager = Defines natural layout for components within a container
		*
		* 3 common managers
		*
		* BorderLayout - A BorderLayout places components in five areas: NORTH, SOOUTH, WEST, EAST, CENTER
		* All extra space is places in the center area*/
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();

		panel1.setBackground(Color.red);
		panel2.setBackground(Color.green);
		panel3.setBackground(Color.yellow);
		panel4.setBackground(Color.magenta);
		panel5.setBackground(Color.blue);

		panel5.setLayout(new BorderLayout());

		// ---------- sub panels ---------
		JPanel panel5_1 = new JPanel();
		JPanel panel5_2 = new JPanel();
		JPanel panel5_3 = new JPanel();
		JPanel panel5_4 = new JPanel();
		JPanel panel5_5 = new JPanel();

		panel5_1.setBackground(Color.black);
		panel5_2.setBackground(Color.darkGray);
		panel5_3.setBackground(Color.gray);
		panel5_4.setBackground(Color.lightGray);
		panel5_5.setBackground(Color.white);

		panel5_1.setPreferredSize(new Dimension(50, 50));
		panel5_2.setPreferredSize(new Dimension(50, 50));
		panel5_3.setPreferredSize(new Dimension(50, 50));
		panel5_4.setPreferredSize(new Dimension(50, 50));
		panel5_5.setPreferredSize(new Dimension(50, 50));

		panel5.add(panel5_1, BorderLayout.NORTH);
		panel5.add(panel5_2, BorderLayout.WEST);
		panel5.add(panel5_3, BorderLayout.SOUTH);
		panel5.add(panel5_4, BorderLayout.EAST);
		panel5.add(panel5_5, BorderLayout.CENTER);

		// ---------- sub panels ---------

		panel1.setPreferredSize(new Dimension(100, 100));
		panel2.setPreferredSize(new Dimension(100, 100));
		panel3.setPreferredSize(new Dimension(100, 100));
		panel4.setPreferredSize(new Dimension(100, 100));
		panel5.setPreferredSize(new Dimension(100, 100));

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(new BorderLayout(10, 10));
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.EAST);
		frame.add(panel3, BorderLayout.SOUTH);
		frame.add(panel4, BorderLayout.WEST);
		frame.add(panel5, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
