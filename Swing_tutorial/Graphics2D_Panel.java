import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.geom.AffineTransform;
import java.awt.Font;

public class Graphics2D_Panel extends JPanel {
	private final Image	charizard;

	public 			Graphics2D_Panel() {
		setPreferredSize(new Dimension(800, 800));
		charizard = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/charizard.png")
			.getImage();
		//charizard = tmp.getScaledInstance(800, 800, Image.SCALE_SMOOTH);
	}

	@Override
	public void		paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.drawImage(charizard,
			AffineTransform.getScaleInstance(800.0 / 475.0, 800.0 / 475.0), null);

		g2.setStroke(new BasicStroke(5));
		g2.setColor(new Color(0x1338be));
		g2.drawLine(0, 0, 800, 800);

		g2.drawLine(0, 800, 800, 0);
		g2.setStroke(new BasicStroke(1));
		g2.setColor(new Color(0xa91b0d));
		g2.fillArc(300, 300, 200, 200, 0, 180);
		g2.setFont(new Font("DooM", Font.PLAIN, 40));
		g2.drawString("This pokemon is locked!", 70, 40);

		//eyes
		g2.setColor(new Color(0x020403));
		//Center of left eyeball { 355, 355 }
		g2.fillOval(340, 340, 30, 30);
		//Center of right eyeball { 445, 335 }
		g2.fillOval(430, 340, 30, 30);

		g2.setColor(new Color(0xfbfcfa));
		g2.fillArc(300, 300, 200, 200, 180, 180);
		g2.fillOval(355, 349, 6, 6);
		g2.fillOval(445, 349, 6, 6);
	}
}
