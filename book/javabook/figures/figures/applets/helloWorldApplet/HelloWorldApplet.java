import java.awt.Container;
import javax.swing.JApplet;

public class HelloWorldApplet extends JApplet {

  public void init() {
    Container contentPane = getContentPane();
    contentPane.add(new HelloWorldPanel());
  }
}
