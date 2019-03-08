import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.PrintJob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FrameEvents extends JFrame {

  public FrameEvents() {
    super();
    setVisible(true);
    setScreen();
    setMenu();
    setBackground(Color.white);

    dialog = new AboutDialog(this);
    Container contentPane = getContentPane();
    contentPane.add(new CalculatorPanel());
    validate();
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
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu help = new JMenu("Help");
    JMenuItem printItem = new JMenuItem("Print");
    JMenuItem exitItem = new JMenuItem("Exit");
    JMenuItem aboutItem = new JMenuItem("About");

    printItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        print();
      }
    });

    exitItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        dispose();
        System.exit(0);
      }
    });

    aboutItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        dialog.setVisible(true);
      }
    });

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        dispose();
        System.exit(0);
      }
    });

    file.add(printItem);
    file.add(exitItem);
    help.add(aboutItem);
    menuBar.add(file);
    menuBar.add(help);
    setJMenuBar(menuBar);
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

    new FrameEvents();
  }

  AboutDialog dialog;
}