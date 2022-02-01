import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;

public class JavaFrame {
    public static void main(String[] args) {
        //JLabel - a GUI display area for a string of text, an image, or both
        //Let's create a lable instance
        JLabel label = new JLabel();
        //set a text of label
        label.setText("Bro, do you even code?");
        //Let's create a border
        Border border = BorderFactory.createLineBorder(Color.green);

        //set image origin
        ImageIcon image = new ImageIcon("/Users/wildboargonnago/Pictures/tzeentch_icon.png");
        //Let's rescale it
        Image cp = image.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        image = null;
        image = new ImageIcon(cp);
        label.setIcon(image);
        //Let's set horizontal text position in frame (LEFT, RIGHT or CENTER of image)
        label.setHorizontalTextPosition(JLabel.CENTER);
        //Let's set vertical text position in frame (TOP, BOTTOM or CENTER of image)
        label.setVerticalTextPosition(JLabel.TOP);
        //Set Foreground color of our text
        label.setForeground(new Color(0x7b32f5));
        //set Font of our text
        label.setFont(new Font("Krungthep", Font.PLAIN, 20));
        //set gap of text to image
        label.setIconTextGap(15);
        //set background color
        label.setBackground(Color.black); //set background color
        label.setOpaque(true); //display background color
        //Let's set Border for a label
        label.setBorder(border);
        //Now lets do center allignment
        label.setVerticalAlignment(JLabel.CENTER); //set vertical position icon + text within the label
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position icon + text within the label
        // set bounds of the label
        label.setBounds(0, 0, 350, 350);

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        frame.setVisible(true);
    }
}
