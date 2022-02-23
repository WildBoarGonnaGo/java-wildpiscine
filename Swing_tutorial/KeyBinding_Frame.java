import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyBinding_Frame {
	private final JFrame	frame;
	private final JLabel	label;
	private final Action	upAction;
	private final Action	downAction;
	private final Action	leftAction;
	private final Action	rightAction;

	public KeyBinding_Frame() {
		frame = new JFrame("Key Binding demo");
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		label = new JLabel();
		//label.setPreferredSize(new Dimension(100, 100));
		label.setBounds(100, 100, 100, 100);
		label.setBackground(Color.blue);
		label.setOpaque(true);

		upAction = new UpAction();
		downAction = new DownAction();
		leftAction = new LeftAction();
		rightAction = new RightAction();

		label.getInputMap().put(KeyStroke.getKeyStroke("UP"), "UpAction");
		label.getActionMap().put("UpAction", upAction);
		label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "DownAction");
		label.getActionMap().put("DownAction", downAction);
		label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "LeftAction");
		label.getActionMap().put("LeftAction", leftAction);
		label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "RightAction");
		label.getActionMap().put("RightAction", rightAction);

		frame.add(label);
		frame.setVisible(true);
	}

	private class UpAction extends AbstractAction {
		@Override
		public void	actionPerformed(ActionEvent e) {
			label.setLocation(label.getX(), label.getY() - 4);
		}
	}

	private class DownAction extends AbstractAction {
		@Override
		public void	actionPerformed(ActionEvent e) {
			label.setLocation(label.getX(), label.getY() + 4);
		}
	}

	private class LeftAction extends AbstractAction {
		@Override
		public void	actionPerformed(ActionEvent e) {
			label.setLocation(label.getX() - 4, label.getY());
		}
	}

	private class RightAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setLocation(label.getX() + 4, label.getY());
		}
	}
}
