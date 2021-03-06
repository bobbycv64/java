package cv64.swing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.PrintJob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameExample extends Frame {

  public FrameExample() {
      setVisible(true);
      setScreen();
      setMenu();
      validate();
  }

  public void paint(Graphics graphics) {
    graphics.drawString("Hello Frames", 100, 100);
  }

  public void print() {
    PrintJob printJob = getToolkit().getPrintJob(this, "Print", null);

    if (printJob != null) {
      Graphics graphics = printJob.getGraphics();

      if (graphics != null) {
        paint(graphics);
        graphics.dispose();
      }
      printJob.end();
    }
  }

  public void setMenu() {
    MenuBar menuBar = new MenuBar();
    Menu menu = new Menu("File");
    MenuItem printItem = new MenuItem("Print");
    MenuItem exitItem = new MenuItem("Exit");

    printItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        print();
      }
    });

    exitItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        System.exit(0);
      }
    });

    menu.add(printItem);
    menu.add(exitItem);
    menuBar.add(menu);
    setMenuBar(menuBar);
  }

  public void setScreen() {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    int screenHeight = dimension.height;
    int screenWidth = dimension.width;

    setSize(screenWidth / 2, screenHeight / 2);
    setLocation(screenWidth / 4, screenHeight / 4);

    String title = "Frame Coordinates: (" +
      screenWidth / 4 + " x, " + screenHeight / 4 +
      " y) Screen size: (" +
      screenWidth / 2 + " pixels wide, " + screenHeight / 2 +
      " pixel high)";

    setTitle(title);
  }

  public static void main(String[] args) {

    new FrameExample();
  }
}
