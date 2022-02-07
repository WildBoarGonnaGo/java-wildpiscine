import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Component;

public class LayeredPaneTrain {
	public static void main(String[] args) {
		/**JLayeredPane	-	Swing container that provides a
		 * 					third dimension for positioning components ex.
		 * 					depth, Z-index*/
		JLabel[]	labels = new JLabel[3];
		int[]		base = new int[2];

		base[0] = 100; base[1] = 100;
		for (int i = 0; i < 3; ++i) {
			labels[i] = new JLabel();
			labels[i].setOpaque(true);
			labels[i].setBounds(base[0] + 50 * i, base[1] + 50 * i, 200, 200);
		}

		labels[0].setBackground(Color.red);
		labels[1].setBackground(Color.green);
		labels[2].setBackground(Color.blue);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,500,500);
		layeredPane.add(labels[0], JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(labels[1], JLayeredPane.DRAG_LAYER);
		layeredPane.add(labels[2], JLayeredPane.MODAL_LAYER);

		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(layeredPane);
		frame.setLayout(null);
		frame.setVisible(true);



	}
}
