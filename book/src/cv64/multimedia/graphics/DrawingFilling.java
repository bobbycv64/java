package cv64.multimedia.graphics;

import java.awt.Color;
import java.awt.Graphics;
import cv64.swing.FrameExample;

public class DrawingFilling extends FrameExample {

  public DrawingFilling() {
    super();
  }

  public void paint(Graphics graphics) {

    // first die - number 3
    graphics.setColor(Color.RED);
    graphics.drawRoundRect(100, 100, 150, 150, 25, 25);
    graphics.setColor(Color.GREEN);
    graphics.fillOval(130, 130, 25, 25);
    graphics.fillOval(165, 165, 25, 25);
    graphics.fillOval(200, 200, 25, 25);

    // second die - number 4
    graphics.setColor(Color.RED);
    graphics.drawRoundRect(270, 100, 150, 150, 25, 25);
    graphics.setColor(Color.GREEN);
    graphics.fillOval(300, 130, 25, 25);
    graphics.fillOval(300, 200, 25, 25);
    graphics.fillOval(370, 130, 25, 25);
    graphics.fillOval(370, 200, 25, 25);
  }

  public static void main(String[] args) {

    DrawingFilling drawingFilling = new DrawingFilling();
    drawingFilling.setBackground(Color.DARK_GRAY);
  }
}
