import java.awt.Color;
import java.awt.Graphics;

public class DrawingFilling extends FrameExample {

  public DrawingFilling() {
    super();
  }

  public void paint(Graphics graphics) {

    graphics.setColor(Color.red);
    graphics.drawLine(50, 50, 250, 50);
    graphics.drawLine(250, 50, 50, 100);
    graphics.drawArc(75, 60, 20, 20, 0, 360);
    graphics.drawRoundRect(100, 100, 150, 150, 25, 25);
    graphics.fillOval(130, 130, 25, 25);
    graphics.fillOval(200, 200, 25, 25);
  }

  public static void main(String[] args) {

    DrawingFilling drawingFilling = new DrawingFilling();
    drawingFilling.setBackground(Color.black);
  }
}