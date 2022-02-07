import java.lang.Thread;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import java.lang.InterruptedException;

public class ProgressBarDemo {
    private final JFrame        frame;
    private final JProgressBar  progressBar;

    public ProgressBarDemo() {
        frame = new JFrame();
        progressBar = new JProgressBar();

        progressBar.setBounds(0, 0, 420, 50);
        //progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setValue(0);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.add(progressBar);
        frame.setVisible(true);

        fill();
    }

    private void    fill() {
        for (int i = 0; i < 100; ++i) {
            try {
                Thread.sleep(500);
                progressBar.setValue(i);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
        progressBar.setString("Done =)");
    }
}
