import javax.swing.JOptionPane;
import java.awt.Image;
import javax.swing.ImageIcon;

public class OptionPaneTrain {
	public static void main(String[] args) {
		/*JOptionPane.showMessageDialog(null, "This is some useless info",
			"title", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(null, "Here is more useless info ... lel",
			"InfoBox", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "really? Oh common?",
			"Question Box", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(null, "You're warned",
			"Warning Box", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null, "Some error occured ... whatever",
			"Error Box", JOptionPane.ERROR_MESSAGE);*/

		ImageIcon icon = new ImageIcon("/Users/wildboargonnago/java-wildpiscine/Swing_tutorial/marks_of_chaos/Tzeentch.png");
		int answer = JOptionPane.showConfirmDialog(null, "Bro do you even code?",
			"Confirm title", JOptionPane.YES_NO_CANCEL_OPTION);
		String 		name = JOptionPane.showInputDialog("What is your name? ");
		String[]	responses = { "No you're awesome!", "thank you", "blush" };
		JOptionPane.showOptionDialog(null,
			"You are awesome",
			"secret message",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.INFORMATION_MESSAGE,
			icon,
			responses,
			0);
		System.out.println(answer);
		System.out.println(name);
	}
}
