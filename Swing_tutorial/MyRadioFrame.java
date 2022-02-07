import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;

public class MyRadioFrame extends JFrame implements ActionListener {
    JRadioButton    khorneButton;
    JRadioButton    slaaneshButton;
    JRadioButton    tzeentchButton;
    ImageIcon       khorneIcon;
    ImageIcon       slaaneshIcon;
    ImageIcon       tzeentchIcon;

    public MyRadioFrame() {

        khorneButton = new JRadioButton("Khorne");
        slaaneshButton = new JRadioButton("Slaanesh");
        tzeentchButton = new JRadioButton("Tzeentch");

        ButtonGroup group = new ButtonGroup();
        group.add(khorneButton);
        group.add(slaaneshButton);
        group.add(tzeentchButton);

        khorneIcon = new ImageIcon("/home/zavelskiymm/marks_of_chaos/Khorne_icon.png");
        Image tmp = khorneIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        khorneIcon = new ImageIcon(tmp);

        slaaneshIcon = new ImageIcon("/home/zavelskiymm/marks_of_chaos/Slaanesh_icon.png");
        tmp = slaaneshIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        slaaneshIcon = new ImageIcon(tmp);

        tzeentchIcon = new ImageIcon("/home/zavelskiymm/marks_of_chaos/Tzeentch.png");
        tmp = tzeentchIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        tzeentchIcon = new ImageIcon(tmp);

        khorneButton.addActionListener(this);
        slaaneshButton.addActionListener(this);
        tzeentchButton.addActionListener(this);

        khorneButton.setIcon(khorneIcon);
        slaaneshButton.setIcon(slaaneshIcon);
        tzeentchButton.setIcon(tzeentchIcon);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));
        this.add(khorneButton);
        this.add(slaaneshButton);
        this.add(tzeentchButton);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == khorneButton) System.out.println("Mark of khorne");
        else if (e.getSource() == slaaneshButton) System.out.println("Mark of Slaanesh");
        else if (e.getSource() == tzeentchButton) System.out.println("Mark of Tzeentch");
    }
}
