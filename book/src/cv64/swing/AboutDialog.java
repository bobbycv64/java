package cv64.swing;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class AboutDialog extends JPanel {
  JLabel label1, label2, label3;

  public AboutDialog(JFrame frame) {
    ImageIcon icon = new ImageIcon("cv64logo.gif", "About cv64.org");
    setLayout(new GridLayout(3,1));

    label1 = new JLabel("Image and Text", icon, JLabel.CENTER);
    label1.setVerticalTextPosition(JLabel.BOTTOM);
    label1.setHorizontalTextPosition(JLabel.CENTER);
    label2 = new JLabel("Robert Estey");
    label3 = new JLabel("Eric Richardson");

    add(label1);
    add(label2);
    add(label3);
  }

    public static void main(String[] args) {
        /*
         * Create a window.  Use JFrame since this window will include
         * lightweight components.
         */
        JFrame frame = new JFrame("LabelDemo");

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setContentPane(new AboutDialog(frame));
        frame.pack();
        frame.setVisible(true);
    }
}
