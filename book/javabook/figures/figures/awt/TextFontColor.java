import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class TextFontColor extends FrameExample {

  public TextFontColor() {
    super();
  }

  public void paint(Graphics graphics) {
    
    Font font;

    // set font to class defaults and color to RED
    font = new Font(fontName_, fontStyle_, fontSize_);
    graphics.setFont(font);
    graphics.setColor(Color.red);
    graphics.drawString("Plain and Red", 100, 100);

    // set font to BOLD and color to WHITE
    font = new Font(fontName_, Font.BOLD, fontSize_);
    graphics.setFont(font);
    graphics.setColor(Color.white);
    graphics.drawString("Bold and White", 125, 125);

    // set font to BOLD and ITALIC, color to BLUE
    font = new Font(fontName_, Font.BOLD + Font.ITALIC, fontSize_);
    graphics.setFont(font);
    // could implement graphics.setColor(color.blue);
    graphics.setColor(new Color(0, 0, 255));
    graphics.drawString("Bold, Italic and Blue", 150, 150);
  }

  public static void main(String[] args) {

    TextFontColor textFontColor = new TextFontColor();
    textFontColor.setBackground(Color.black);
  }

  private String fontName_ = "Arial";
  private int fontStyle_ = Font.PLAIN;
  private int fontSize_ = 14;
}