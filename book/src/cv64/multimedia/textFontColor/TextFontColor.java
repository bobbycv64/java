package cv64.multimedia.textFontColor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import cv64.swing.FrameExample;

public class TextFontColor extends FrameExample {

  private String fontName = "Arial";
  private int fontStyle = Font.PLAIN;
  private int fontSize = 14;

  public TextFontColor() {
    super();
  }

  public void paint(Graphics graphics) {

    Font font;

    // set font to class defaults and color to RED
    font = new Font(fontName, fontStyle, fontSize);
    graphics.setFont(font);
    graphics.setColor(Color.RED);
    graphics.drawString("Plain and Red", 100, 100);

    // set font to BOLD and color to WHITE
    font = new Font("Courier", Font.BOLD, fontSize);
    graphics.setFont(font);
    graphics.setColor(Color.WHITE);
    graphics.drawString("Bold and White", 125, 125);

    // set font to BOLD and ITALIC, color to BLUE
    font = new Font(fontName, Font.BOLD + Font.ITALIC, fontSize);
    graphics.setFont(font);
    // could implement graphics.setColor(Color.BLUE);
    graphics.setColor(new Color(0, 0, 255));
    graphics.drawString("Bold, Italic and Blue", 150, 150);

    // set font to Courier, BOLD, ITALIC, color to GREEN and Larger
    font = new Font("Courier", Font.BOLD + Font.ITALIC, 20);
    graphics.setFont(font);
    graphics.setColor(new Color(0, 255, 0));
    graphics.drawString(
      "Courier, Bold, Italic, Green and Larger", 25, 200);
  }

  public static void main(String[] args) {

    TextFontColor textFontColor = new TextFontColor();
    textFontColor.setBackground(Color.BLACK);
  }
}
