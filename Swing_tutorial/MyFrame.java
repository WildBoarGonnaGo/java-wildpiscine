import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        this.setTitle("MyFrame window");
        this.setSize(420, 420);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(123, 50, 250));
        ImageIcon icon = new ImageIcon("/Users/wildboargonnago/qt_logo.png");
        this.setIconImage(icon.getImage());
        this.setVisible(true);
    }
}
