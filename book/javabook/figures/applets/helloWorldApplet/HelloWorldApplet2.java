import java.applet.Applet;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JApplet;

public class HelloWorldApplet extends JApplet {

  public void init() {
//    Container contentPane = getContentPane();
//    contentPane.add(new HelloWorldPanel());
  }

  public void paint(Graphics graphics) {
    graphics.drawString("Sound Example", 25, 25);
    play(getDocumentBase(), "flush.au");
  }
}