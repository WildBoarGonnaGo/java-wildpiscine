import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class TextFieldFrame extends JFrame {
	private final JButton		button;
	private final JTextField	field;

	public TextFieldFrame() {
		button = new JButton("Submit");
		field = new JTextField();

		button.setPreferredSize(new Dimension(100, 50));
		button.addActionListener(e -> {
			button.setEnabled(false);
			System.out.println("Welcome, " + field.getText() + '!');
		});

		field.setPreferredSize(new Dimension(200, 50));
		field.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		field.setBackground(new Color(0x373737));
		field.setForeground(new Color(0xfbfaf2));
		field.setCaretColor(new Color(0xfbfaf2));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.add(button);
		this.add(field);
		this.pack();

		this.setVisible(true);
	}
}
