import javax.swing.*;
import java.awt.Font;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.GridLayout;
import java.awt.Dimension;

public class SliderDemo implements ChangeListener {
    private final JLabel    label;
    private final JSlider   slider;
    private final JPanel    panel;


    public SliderDemo() {
        JFrame  frame = new JFrame();
        label = new JLabel();
        slider = new JSlider(0, 100, 50);
        panel = new JPanel();

        slider.setPreferredSize(new Dimension(400, 200));
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setPaintTrack(true);
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.setValue(50);
        slider.setFont(new Font("Ubuntu", Font.PLAIN, 15));
        slider.setSnapToTicks(false);
        slider.addChangeListener(this);

        label.setFont(new Font("Ubuntu", Font.PLAIN, 25));
        label.setText("T\u00b0C = " + slider.getValue());

        panel.add(slider);
        panel.add(label);

        frame.setSize(420, 420);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText("T\u00b0C = " + slider.getValue());
    }
}
