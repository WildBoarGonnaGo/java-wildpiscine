import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Image;

public class NewWindow {
	private final	JFrame frame;
	private final	JLabel label;

	public NewWindow() {
		frame = new JFrame();
		label = new JLabel("Blood for the Blood God!");

		ImageIcon icon = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/Khorne_icon.png");
		Image tmp = icon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		icon = new ImageIcon(tmp);

		label.setBounds(60, 100, 300, 200);
		label.setForeground(new Color(0xFFF600));
		label.setBackground(new Color(0xd21404));
		label.setFont(new Font("Copperplate", Font.BOLD, 20));
		label.setIcon(icon);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.BOTTOM);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setOpaque(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.add(label);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
