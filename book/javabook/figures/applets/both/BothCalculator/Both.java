import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class Both extends JApplet {

  public void init() {
    JPanel panel = new JPanel();
    panel.add(new CalculatorPanel());
    setContentPane(panel);
  }
  public void start() {}
  public void stop() {}
  public void destroy() {
    System.exit(0);
  }

//  public void paint(Graphics graphics) {
//    graphics.drawString("Both Applet and Application", 25, 25);
//  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Java Application");
    Both both = new Both();

    frame.setSize(200, 100);
    frame.setVisible(true);
    frame.validate();

    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        System.exit(0);
      }
    });

    both.init();
    both.start();
  }
}