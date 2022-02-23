import javax.swing.JFrame;

public class Animation_Frame extends JFrame {

	public Animation_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new Animation_Panel());
		pack();
		setVisible(true);
	}
}
