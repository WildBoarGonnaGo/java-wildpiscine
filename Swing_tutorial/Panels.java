import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;

public class Panels {
	public static void main(String[] args) {
		//JPanel - a GUI component that functions as a container to hold other components
		JLabel	label = new JLabel();
		label.setText("Hi");
		label.setForeground(new Color(0xFFE800));
		label.setFont(new Font("Krungthep", Font.PLAIN, 30));
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

		JLabel	itLabel = new JLabel();
		itLabel.setText("It's");
		itLabel.setForeground(new Color(0x80471C));
		itLabel.setFont(new Font("Krungthep", Font.PLAIN, 30));
		itLabel.setVerticalTextPosition(JLabel.CENTER);
		itLabel.setHorizontalAlignment(JLabel.CENTER);

		JLabel	dioLabel = new JLabel();
		dioLabel.setText("DIO");
		dioLabel.setForeground(new Color(0xBD1816));
		dioLabel.setFont(new Font("Krungthep", Font.PLAIN, 30));
		dioLabel.setVerticalTextPosition(JLabel.CENTER);
		dioLabel.setHorizontalAlignment(JLabel.CENTER);

		JPanel	redPanel = new JPanel();
		redPanel.setBackground(Color.red);
		redPanel.setBounds(0, 0, 200, 200);
		redPanel.setLayout(new BorderLayout());
		redPanel.add(label);

		JPanel	greenPanel = new JPanel();
		greenPanel.setBackground(Color.green);
		greenPanel.setBounds(200, 0, 200, 200);
		greenPanel.setLayout(new BorderLayout());
		greenPanel.add(itLabel);

		JPanel	yellowPanel = new JPanel();
		yellowPanel.setBackground(Color.yellow);
		yellowPanel.setBounds(0, 200, 400, 200);
		yellowPanel.setLayout(new BorderLayout());
		yellowPanel.add(dioLabel);

		JFrame frame = new JFrame();
		frame.setSize(750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(redPanel);
		frame.add(greenPanel);
		frame.add(yellowPanel);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
