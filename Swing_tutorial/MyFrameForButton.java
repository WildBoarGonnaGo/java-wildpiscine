import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class MyFrameForButton extends JFrame implements ActionListener {
	private final JButton button;

	MyFrameForButton() {
		button = new JButton();
		button.setBounds(100, 100, 100, 100);
		button.addActionListener(this);
		button.setText("Tzeentch");
		button.setFont(new Font("Kefa", Font.PLAIN, 20));
		button.setForeground(new Color(0x1520a6));

		//Introducing lambda expression

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500, 500);
		this.add(button);
		this.setVisible(true);
	}

	@Override
	public void	actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			System.out.println("\u001b[1;38;5;4mGaze the mark of the Architect of Fate, Tzeentch\u001b[0m");
		}
	}
}
