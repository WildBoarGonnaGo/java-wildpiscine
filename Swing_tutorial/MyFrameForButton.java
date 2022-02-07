import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.BorderFactory;

public class MyFrameForButton extends JFrame implements ActionListener {
	private final JButton button;
	private final JButton khorne;
	private final JButton nurgle;
	private final JButton slaanesh;

	MyFrameForButton() {
		ImageIcon khorneIcon = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/Khorne_icon.png");
		Image tmp = khorneIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		khorneIcon = new ImageIcon(tmp);

		ImageIcon nurgleIcon = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/nurgle_icon.jpeg");
		tmp = nurgleIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		nurgleIcon = new ImageIcon(tmp);

		ImageIcon TzeentchIcon = new ImageIcon(("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/Tzeentch.png"));
		tmp = TzeentchIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		TzeentchIcon = new ImageIcon(tmp);

		ImageIcon SlaaneshIcon = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/Slaanesh_icon.png");
		tmp = SlaaneshIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		SlaaneshIcon = new ImageIcon(tmp);

		button = new JButton();
		button.setBounds(100, 50, 300, 100);
		button.addActionListener(this);
		button.setText("Mark of Tzeentch");
		button.setFont(new Font("Kefa pressS", Font.PLAIN, 20));
		button.setForeground(new Color(0x1520a6));
		button.setIcon(TzeentchIcon);
		button.setHorizontalTextPosition(JButton.RIGHT);
		button.setVerticalTextPosition(JButton.CENTER);
		button.setVerticalAlignment(JButton.CENTER);
		button.setHorizontalAlignment(JButton.CENTER);
		button.setBorder(BorderFactory.createRaisedBevelBorder());
		button.setFocusable(false);

		khorne = new JButton();
		khorne.setBounds(100, 150, 300, 100);
		khorne.setText("Mark of Khorne");
		khorne.setFont(new Font("Kefa pressS", Font.PLAIN, 20));
		khorne.setForeground(new Color(0x710c04));
		khorne.setIcon(khorneIcon);
		khorne.setHorizontalTextPosition(JButton.RIGHT);
		khorne.setVerticalTextPosition(JButton.CENTER);
		khorne.setVerticalAlignment(JButton.CENTER);
		khorne.setHorizontalAlignment(JButton.CENTER);
		//Introducing lambda expression
		khorne.addActionListener(e -> {
			System.out.println("\u001b[1;38;5;160mBlood for the Blood God\nSkulls for the Skull Throne!\u001b[0m");
		});
		khorne.setBorder(BorderFactory.createRaisedBevelBorder());
		khorne.setFocusable(false);

		nurgle = new JButton();
		nurgle.setBounds(100, 250, 300, 100);
		nurgle.setText("Mark of Nurgle");
		nurgle.setFont(new Font("Kefa PressS", Font.PLAIN, 20));
		nurgle.setForeground(new Color(0x466d1d));
		nurgle.setIcon(nurgleIcon);
		nurgle.setHorizontalTextPosition(JButton.RIGHT);
		nurgle.setVerticalTextPosition(JButton.CENTER);
		nurgle.setHorizontalAlignment(JButton.CENTER);
		nurgle.setVerticalAlignment(JButton.CENTER);
		nurgle.addActionListener(e -> {
			System.out.println("\u001b[1;38;5;40mSearch for beauty in all things, and when found, celebrate it\u001b[0m");
			System.out.println("\u001b[1;38;5;40mAnd when beauty is found, perfect it by sharing the blessings of Nurgle\u001b[0m");
		});
		nurgle.setBorder(BorderFactory.createRaisedBevelBorder());
		nurgle.setFocusable(false);

		slaanesh = new JButton();
		slaanesh.setBounds(100, 350, 300, 100);
		slaanesh.setText("Mark of Slaanesh");
		slaanesh.setFont(new Font("Kefa PressS", Font.PLAIN, 20));
		slaanesh.setForeground(new Color(0x710193));
		slaanesh.setIcon(SlaaneshIcon);
		slaanesh.setHorizontalTextPosition(JButton.RIGHT);
		slaanesh.setVerticalTextPosition(JButton.CENTER);
		slaanesh.setHorizontalAlignment(JButton.CENTER);
		slaanesh.setVerticalAlignment(JButton.CENTER);
		slaanesh.addActionListener(this);
		slaanesh.setBorder(BorderFactory.createRaisedBevelBorder());
		slaanesh.setFocusable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500, 500);
		this.add(button);
		this.add(khorne);
		this.add(nurgle);
		this.add(slaanesh);
		this.setVisible(true);
	}

	@Override
	public void	actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			System.out.println("\u001b[1;38;5;4mGaze the mark of the Architect of Fate, Tzeentch\u001b[0m");
		}
		else if (e.getSource() == slaanesh) {
			System.out.println("\u001b[1;38;5;164mEmbrace your hunger, your lust, your desire\u001b[0m");
			System.out.println("\u001b[1;38;5;164mThe universe is ours for the taking\u001b[0m");
		}
	}
}
