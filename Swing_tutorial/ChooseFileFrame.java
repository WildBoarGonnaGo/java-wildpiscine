import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;

public class ChooseFileFrame extends JFrame implements ActionListener {
	JButton	button;

	public 			ChooseFileFrame() {
		button = new JButton("Select File");
		button.setText("Select File");
		button.setPreferredSize(new Dimension(300, 150));
		button.setFont(new Font("Futura", Font.PLAIN, 35));
		button.setHorizontalAlignment(JButton.CENTER);
		button.setVerticalAlignment(JButton.CENTER);
		button.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		add(button);
		pack();
		setVisible(true);
	}

	@Override
	public void		actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			JFileChooser choose = new JFileChooser();
			choose.setCurrentDirectory(new File("/Users/wildboargonnago/"));
			int state = choose.showSaveDialog(null);
			if (state == JFileChooser.APPROVE_OPTION) System.out.println(choose.getSelectedFile().getAbsolutePath());
		}
	}
}
