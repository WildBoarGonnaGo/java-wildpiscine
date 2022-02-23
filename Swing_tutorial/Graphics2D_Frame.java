import javax.swing.JFrame;
import java.awt.FlowLayout;

public class Graphics2D_Frame {
	private final JFrame 			frame;
	private final Graphics2D_Panel	panel;

	public Graphics2D_Frame() {
		panel = new Graphics2D_Panel();

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
