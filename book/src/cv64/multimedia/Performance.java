package cv64.multimedia;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import cv64.multimedia.graphics.Images;
import cv64.swing.FrameExample;

public class Performance extends FrameExample {

  private Image bufferedImage;
  private boolean compute = true;

  public Performance() {
    super();
  }

  public Image getImage() {
    return Toolkit.getDefaultToolkit().getImage("max.jpg");
  }

  // override update method to not clear screen before painting.
  public void update(Graphics graphics) {
    paint(graphics);
  }

  public void paint(Graphics graphics) {

    if (compute) {
      System.out.println("width: " + getSize().width +
        " height: " + getSize().height);

      bufferedImage = createImage(getSize().width, getSize().height);
      Graphics bufferedGraphics = bufferedImage.getGraphics();
      bufferedGraphics.drawImage(getImage(), 100, 100, this);
      bufferedGraphics.dispose();
      compute = false;
    }
    graphics.drawImage(bufferedImage, 0, 0, null);
  }

  public static void main(String[] args) {

    Images images = new Images();
    images.setBackground(Color.white);
  }
}
