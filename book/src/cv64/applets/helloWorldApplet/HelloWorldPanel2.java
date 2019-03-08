package cv64.applets.helloWorldApplet;

import java.awt.Graphics;
import javax.swing.JPanel;

public class HelloWorldPanel2 extends JPanel {

  public void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    graphics.drawString("Hello World Applet", 20, 20);
  }
}
