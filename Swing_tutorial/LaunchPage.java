import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LaunchPage implements ActionListener {
	private final	JFrame frame;
	private	final	JButton	button;

	public LaunchPage() {
		frame = new JFrame();
		button = new JButton("New Window");

		button.setBounds(110, 160, 200, 40);
		button.setFocusable(false);
		button.addActionListener(this);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(button);
	}

	@Override
	public void	actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			frame.dispose();
			NewWindow window = new NewWindow();
		}
	}
}
