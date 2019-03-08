package cv64.multimedia.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import cv64.swing.FrameExample;

public class Images extends FrameExample {

  public Images() {
    super();
  }

  public Image getImage() {
    return Toolkit.getDefaultToolkit().getImage("max.jpg");
  }

  public void paint(Graphics graphics) {
    graphics.drawImage(getImage(), 50, 150, this);
  }

  public static void main(String[] args) {

    Images images = new Images();
    images.setBackground(Color.white);
  }
}
