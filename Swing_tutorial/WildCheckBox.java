import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class WildCheckBox extends JFrame implements ActionListener {
	private final JButton	button;
	private final JCheckBox	checkBox;
	private final String ESC = "\u001b";

	public WildCheckBox() {
		button = new JButton("Done");
		checkBox = new JCheckBox("Choose your destiny");

		ImageIcon	chaos = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/Chaos_Warrior_Emblem.png");
		Image		tmp = chaos.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		chaos = new ImageIcon(tmp);

		ImageIcon	empire = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/Empire_shield.png");
		tmp = empire.getImage().getScaledInstance(60, 80, Image.SCALE_SMOOTH);
		empire = new ImageIcon(tmp);

		button.setFocusable(false);
		button.setPreferredSize(new Dimension(100, 60));
		button.addActionListener(this);

		checkBox.setFont(new Font("Futura", Font.PLAIN, 25));
		checkBox.setForeground(new Color(0x1520a6));
		checkBox.setIcon(chaos);
		checkBox.setSelectedIcon(empire);
		checkBox.setFocusable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.add(button);
		this.add(checkBox);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void		actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			String	chaosStr = ESC + "[1;38;5;196mChaos is the only true answer!" + ESC + "[0m";
			String	empireStr = ESC + "[1;38;5;190mEmpire will rise again!" + ESC + "[0m";
			System.out.println((checkBox.isSelected()) ? empireStr : chaosStr);
		}
	}
}
