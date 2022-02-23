import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;

public class KeyEventShipFrame extends JFrame implements KeyListener {
	private final JLabel			label;
	private final Image				boat_right;
	private final Image				boat_left;
	private final ImageIcon			boat_leftIcon;
	private final ImageIcon			boat_rightIcon;
	private final boolean 			RIGHT = true;
	private final boolean			LEFT = false;
	private boolean					dir;

	public KeyEventShipFrame() {
		ImageIcon icon = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/ship.png");
		boat_right = icon.getImage().getScaledInstance(200, 165, Image.SCALE_SMOOTH);
		boat_rightIcon = new ImageIcon(boat_right);

		icon = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/left_ship.png");
		boat_left = icon.getImage().getScaledInstance(200, 165, Image.SCALE_SMOOTH);
		boat_leftIcon = new ImageIcon(boat_left);

		label = new JLabel();
		icon = boat_rightIcon;
		label.setBounds(0, 0, 200, 165);
		label.setIcon(boat_rightIcon);
		dir = RIGHT;

		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1000, 1000));
		getContentPane().setBackground(new Color(0x006892));
		addKeyListener(this);
		add(label);
		setVisible(true);
	}

	@Override
	public void	keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case 37:
				if (dir == RIGHT) { dir = LEFT; label.setIcon(boat_leftIcon); }
				label.setLocation(label.getX() - 5, label.getY());
				break ;
			case 38: label.setLocation(label.getX(), label.getY() - 5); break ;
			case 39:
				if (dir == LEFT) { dir = RIGHT; label.setIcon(boat_rightIcon); }
				label.setLocation(label.getX() + 5, label.getY());
				break ;
			case 40: label.setLocation(label.getX(), label.getY() + 5); break ;
			default: break;
		}
	}

	@Override
	public void	keyTyped(KeyEvent e) {
		switch(e.getKeyChar()) {
			case 'a':
				if (dir == RIGHT) { dir = LEFT; label.setIcon(boat_leftIcon); }
				label.setLocation(label.getX() - 5, label.getY());
				break ;
			case 'w': label.setLocation(label.getX(), label.getY() - 5); break ;
			case 'd':
				if (dir == LEFT) { dir = RIGHT; label.setIcon(boat_rightIcon); }
				label.setLocation(label.getX() + 5, label.getY());
				break ;
			case 's': label.setLocation(label.getX(), label.getY() + 5); break ;
			default: break;
		}
	}

	@Override
	public void	keyReleased(KeyEvent e) {
		//System.out.println("Code of released key is: " + e.getKeyCode());
	}
}