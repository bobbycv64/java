package cv64.applets.helloWorldApplet;

import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HelloWorldPanel extends JPanel {

  public HelloWorldPanel() {
    add(new JButton("test"));
  }

  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    graphics.drawString("Hello World Applet", 20, 20);
  }
}
