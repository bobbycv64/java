import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Images extends FrameExample {

  public Images() {
    super();
  }

  public Image getImage() {
    return Toolkit.getDefaultToolkit().getImage("cv64logo.gif");
  }

  public void paint(Graphics graphics) {
    graphics.drawImage(getImage(), 100, 100, this);
  }

  public static void main(String[] args) {

    Images images = new Images();
    images.setBackground(Color.white);
  }
}