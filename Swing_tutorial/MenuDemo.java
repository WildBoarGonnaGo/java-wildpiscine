import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class MenuDemo extends JFrame implements ActionListener {
	private final JMenuBar	menuBar;
	private final JMenu		helpMenu;
	private final JMenu		editMenu;
	private final JMenu		fileMenu;
	private final JMenuItem	openItem;
	private final JMenuItem	saveItem;
	private final JMenuItem	exitItem;
	private final ImageIcon	saveIcon;
	private final ImageIcon	openIcon;
	private final ImageIcon exitIcon;

	public MenuDemo() {
		menuBar = new JMenuBar();

		saveIcon = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos")

		helpMenu = new JMenu("Help");
		editMenu = new JMenu("Edit");
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		openItem = new JMenuItem("Open");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");

		openItem.addActionListener(this);
		saveItem.addActionListener(this);
		exitItem.addActionListener(this);

		fileMenu.add(saveItem);
		fileMenu.add(openItem);
		fileMenu.add(exitItem);

		this.setSize(420, 420);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setJMenuBar(menuBar);
		this.setVisible(true);
	}

	@Override
	public void	actionPerformed(ActionEvent e) {
		if (e.getSource() == openItem) System.out.println("File open process imitation");
		else if (e.getSource() == saveItem) System.out.println("File save process imitation");
		else if (e.getSource() == exitItem) System.exit(0);
	}
}
