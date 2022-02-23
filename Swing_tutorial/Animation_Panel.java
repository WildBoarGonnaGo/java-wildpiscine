import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.ActionEvent;

public class Animation_Panel extends JPanel implements ActionListener{
	private int			x;
	private int			y;
	private int			xVelocity;
	private int			yVelocity;
	private final int	width;
	private final int	height;
	private final int	spaceWidth;
	private final int	spaceHeight;
	private final Image	asteroid;
	private final Image	space;
	private final Timer	timer;

	public Animation_Panel() {
		x = 0;
		y = 0;
		xVelocity = 2;
		yVelocity = 1;
		asteroid = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/asteroid.png").getImage();
		space = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/space.jpeg").getImage();
		width = asteroid.getWidth(null);
		height = asteroid.getHeight(null);
		spaceWidth = space.getWidth(null);
		spaceHeight = space.getHeight(null);
		timer = new Timer(10, this);
		timer.start();
		setPreferredSize(new Dimension(spaceWidth, spaceHeight));
		setOpaque(true);
	}

	@Override
	public void	paint(Graphics g) {
		super.paint(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(space, 0, 0, null);
		g2.drawImage(asteroid, x, y, null);
	}

	@Override
	public void	actionPerformed(ActionEvent e) {
		if (x >= spaceWidth - width || x < 0) xVelocity *= -1;
		if (y >= spaceHeight - height || y < 0) yVelocity *= -1;
		x += xVelocity; y+= yVelocity;
		repaint();
	}
}
