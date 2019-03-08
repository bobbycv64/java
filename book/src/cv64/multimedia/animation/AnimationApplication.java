package cv64.multimedia.animation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnimationApplication extends JPanel implements Runnable {

  private int imageIndex = 0;
  private int maxThreadSize = 5;
  private int theadIndex = 0;
  private int x = 0;
  private int y = 0;

  private Image[] foregroundImage = new Image[maxThreadSize];
  private Image backgroundImage = null;
  private Thread[] threads = new Thread[maxThreadSize];

  public AnimationApplication() {
    Toolkit kit = Toolkit.getDefaultToolkit();
    foregroundImage[0] = kit.getImage("foreground0.gif");
    foregroundImage[1] = kit.getImage("foreground1.gif");
    foregroundImage[2] = kit.getImage("foreground2.gif");
    foregroundImage[3] = kit.getImage("foreground3.gif");
    foregroundImage[4] = kit.getImage("foreground4.gif");
    backgroundImage = kit.getImage("background.gif");
  }

  public void paintComponent(Graphics graphics) {
    Graphics2D graphics2D = (Graphics2D) graphics;

    if ((backgroundImage != null) && (foregroundImage[imageIndex] != null)) {
      graphics2D.drawImage(backgroundImage, 0, 0, this);
      graphics2D.drawImage(foregroundImage[imageIndex], x, y, this);
    }
  }

  public void run() {
    Thread currentThread = Thread.currentThread();  // get the thread parameters

    try {
        for (int i=0; i < 10; i++) {
          System.out.println("Iteration: " + i + " of " + currentThread.getName());
          imageIndex = Integer.parseInt(currentThread.getName().substring(7,8)) - 1;
          x = (int)(Math.random() * (imageIndex + 475));
          y = (int)(Math.random() * (imageIndex + 475));
          currentThread.sleep((long)(Math.random() * 5000));
          repaint();
        }
    } catch (InterruptedException exception) {
        exception.getMessage();
        exception.getStackTrace();
    }
    System.out.println("End of Thread: " + currentThread.getName());
  }

  public void start() {
    if (theadIndex >= maxThreadSize) System.exit(-1);
    threads[theadIndex] = new Thread(this);  // create a new thread
    threads[theadIndex].start();             // call the run method for the thread
    theadIndex++;
  }

  public static void main(String[] args) {

    AnimationApplication animationApplication = new AnimationApplication();
    JFrame frame = new JFrame("Animation Application");
    frame.setSize(475, 475);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(animationApplication);
    frame.setVisible(true);

    for (int i = 0; i < 5; i++) {
      animationApplication.start();
    }
  }
}
