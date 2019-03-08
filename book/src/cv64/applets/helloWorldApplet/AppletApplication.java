package cv64.applets.helloWorldApplet;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JApplet;
import javax.swing.JFrame;

public class AppletApplication extends JApplet {

  public void init() {}
  public void start() {}
  public void stop() {}
  public void destroy() {}

  public void paint(Graphics graphics) {
    Graphics2D graphics2D = (Graphics2D)graphics;
    graphics2D.drawString("Sound Example", 25, 25);
    play(getDocumentBase(), "soundExample.au");
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Applet / Application");
    AppletApplication appletApplication = new AppletApplication();

    frame.getContentPane().add(appletApplication);
    frame.setSize(200, 100);
    frame.setVisible(true);
    frame.validate();

    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        System.exit(0);
      }
    });

    appletApplication.init();
    appletApplication.start();
  }
}
