import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class DragAndDrop_Panel extends JPanel {
	private ImageIcon			icon;
	private Point				startPt;
	private Point				prevPt;
	private final MouseGrep		grep;
	private final MouseDragg	dragg;

	/*private ImageIcon createIcon(int width, int height, String fileName) {
		ImageIcon result = new ImageIcon(fileName);
		Image image = result.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		result = new ImageIcon(image);
		return result;
	}*/

	public DragAndDrop_Panel() {
		icon = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/some_jet.png");
		Image image = icon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
		icon = new ImageIcon(image);

		startPt = new Point(0, 0);
		grep = new MouseGrep();
		dragg = new MouseDragg();

		addMouseListener(grep);
		addMouseMotionListener(dragg);
	}

	/*In short. JPanel is a canvas, and superPaint.component is a drawer
	* It must be called to ensure correct redraw. It isn't called directly:
	* it ls called by JVM, or by this.repaint function indirectly*/
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		icon.paintIcon(this, g, (int)startPt.getX(), (int)startPt.getY());
	}

	private class MouseGrep extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			prevPt = e.getPoint();
		}
	}

	private class MouseDragg extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent e) {
			Point currPt = e.getPoint();
			startPt.translate(	(int)(currPt.getX() - prevPt.getX()),
				(int)(currPt.getY() - prevPt.getY()));
			prevPt = currPt;
			//repaint function calls paintComponent method
			repaint();
		}
	}
}
