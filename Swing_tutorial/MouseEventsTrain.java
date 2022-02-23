import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MouseEventsTrain extends JFrame implements MouseListener {
	private final JLabel label;
	private ImageIcon awesomeNice;
	private ImageIcon awesomeWut;
	private ImageIcon awesomeHey;
	private ImageIcon awesomeDizzy;

	public MouseEventsTrain() {
		awesomeNice = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/awesome_fine.png");
		Image image = awesomeNice.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		awesomeNice = new ImageIcon(image);

		awesomeHey = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/awesome_hey.png");
		image = awesomeHey.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		awesomeHey = new ImageIcon(image);

		awesomeWut = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/awesome_suspicious.png");
		image = awesomeWut.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		awesomeWut = new ImageIcon(image);

		awesomeDizzy = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/awesome_dizzy.png");
		image = awesomeDizzy.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
		awesomeDizzy = new ImageIcon(image);

		label = new JLabel();
		label.setPreferredSize(new Dimension(500, 500));
		label.setIcon(awesomeNice);
		label.addMouseListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		add(label);
		pack();
		setVisible(true);
	}

	@Override
	public void	mouseClicked(MouseEvent e) {
		label.setIcon(awesomeHey);
		System.out.println("Mouse clicked!");
	}

	@Override
	public void	mouseEntered(MouseEvent e) {
		label.setIcon(awesomeWut);
		System.out.println("Mouse entered!");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		label.setIcon(awesomeNice);
		System.out.println("Mouse exited!");
	}

	@Override
	public void	mousePressed(MouseEvent e) {
		label.setIcon(awesomeHey);
		System.out.println("Mouse pressed!");
	}

	@Override
	public void	mouseReleased(MouseEvent e) {
		label.setIcon(awesomeDizzy);
		System.out.println("Mouse released!");
	}
}
