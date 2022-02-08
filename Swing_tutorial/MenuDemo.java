import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class MenuDemo extends JFrame implements ActionListener {
	private final JMenuBar	menuBar;
	private final JMenu		helpMenu;
	private final JMenu		editMenu;
	private final JMenu		fileMenu;
	private final JMenuItem	openItem;
	private final JMenuItem	saveItem;
	private final JMenuItem	exitItem;
	private ImageIcon		saveIcon;
	private ImageIcon		openIcon;
	private ImageIcon		exitIcon;

	public MenuDemo() {
		menuBar = new JMenuBar();

		saveIcon = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/save.jpeg");
		Image tmp = saveIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		saveIcon = new ImageIcon(tmp);

		openIcon = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/cloud_icon_download.png");
		tmp = openIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		openIcon = new ImageIcon(tmp);

		exitIcon = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/exit.jpeg");
		tmp = exitIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		exitIcon = new ImageIcon(tmp);

		helpMenu = new JMenu("Help");
		editMenu = new JMenu("Edit");
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);

		openItem = new JMenuItem("Open");
		saveItem = new JMenuItem("Save");
		exitItem = new JMenuItem("Exit");

		openItem.setIcon(openIcon);
		saveItem.setIcon(saveIcon);
		exitItem.setIcon(exitIcon);

		openItem.setMnemonic(KeyEvent.VK_O); // O Key to open file
		exitItem.setMnemonic(KeyEvent.VK_E); // E key to exit program
		saveItem.setMnemonic(KeyEvent.VK_S); // S key to save file

		fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + F for File submenu
		editMenu.setMnemonic(KeyEvent.VK_E); // Alt + E for Edit submenu
		helpMenu.setMnemonic(KeyEvent.VK_H); // Alt + E for help menu

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
