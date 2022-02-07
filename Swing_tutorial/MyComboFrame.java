import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.FlowLayout;

public class MyComboFrame extends JFrame {
    private final JComboBox<String> comboBox;

    public MyComboFrame() {
        comboBox = new JComboBox<>();

        String[]    arr = { "cat", "dog", "bird" };
        for (int i = 0; i < arr.length; ++i) comboBox.addItem(arr[i]);
        comboBox.insertItemAt("rooster", 0);
        comboBox.insertItemAt("horse", 0);
        comboBox.setSelectedIndex(0);
        //comboBox.removeItemAt(3);
        comboBox.setEditable(true);
        comboBox.setEditable(false);
        comboBox.addActionListener(e -> {
            System.out.print(comboBox.getSelectedIndex());
            System.out.print(' ');
            System.out.println(comboBox.getSelectedItem());
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(comboBox);
        this.pack();
        this.setVisible(true);
    }

}
