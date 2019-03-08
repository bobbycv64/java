import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Performance extends FrameExample {

  public Performance() {
    super();
  }

  public Image getImage() {
    return Toolkit.getDefaultToolkit().getImage("cv64logo.gif");
  }

  // override update method to not clear screen before painting.
  public void update(Graphics graphics) {
    paint(graphics);
  }

  public void paint(Graphics graphics) {

    if (compute_) {
      System.out.println("width: " + getSize().width + 
        " height: " + getSize().height);

      bufferedImage = createImage(getSize().width, getSize().height);
      Graphics bufferedGraphics = bufferedImage.getGraphics();
      bufferedGraphics.drawImage(getImage(), 100, 100, this);
      bufferedGraphics.dispose();
      compute_ = false;
    }
    graphics.drawImage(bufferedImage, 0, 0, null);
  }

  public static void main(String[] args) {

    Images images = new Images();
    images.setBackground(Color.white);
  }

  private Image bufferedImage;
  private boolean compute_ = true;
}