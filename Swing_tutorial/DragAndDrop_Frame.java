import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DragAndDrop_Frame extends JFrame {
	private DragAndDrop_Panel	dad_panel;

	public DragAndDrop_Frame() {
		dad_panel = new DragAndDrop_Panel();

		this.add(dad_panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.getContentPane().setBackground(new Color(0x63c5da));
		this.setTitle("Drag and Drop demo");
		this.setVisible(true);
	}
}
