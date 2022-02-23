import javax.swing.JFrame;
import javax.swing.JColorChooser;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Dimension;

public class ColorFrame extends JFrame implements ActionListener {
	JLabel	label;
	JButton	button;

	public	ColorFrame() {
		button = new JButton("Pick a color");
		button.setFont(new Font("Futura", Font.PLAIN, 20));
		button.setPreferredSize(new Dimension(200, 80));
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.CENTER);
		button.addActionListener(this);

		label = new JLabel("Some Color Text");
		label.setFont(new Font("DooM", Font.PLAIN, 35));
		label.setPreferredSize(new Dimension(600, 80));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		add(button);
		add(label);
		pack();
		setVisible(true);
	}

	@Override
	public void	actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			JColorChooser chooser = new JColorChooser();
			Color color = chooser.showDialog(null, "Doom text color", Color.black);
			label.setForeground(color);
		}
	}
}
