import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutTrain {
	public static void main(String[] args) {
		/**
		 * Layout Manager =		Defines the natural layout for components within a container
		 *
		 * GridLayout =			places components in a grid of cells. Each component
		 * 						takes all the available space within it's cell,
		 * 						and each cell is the same size
		 * */

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(3, 3, 10, 10));

		//JButton[] buttons = (JButton[]) new Component[10];
		for (int i = 0; i < 10; ++i) frame.add(new JButton(Integer.toString(i + 1)));
		frame.setVisible(true);
	}
}
