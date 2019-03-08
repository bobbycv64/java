package cv64.multimedia.animation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JApplet;

public class AnimationApplet extends JApplet implements Runnable {

  private int delayTimer = 5000;  // sleep 5 seconds
  private int imageIndex = 0;
  private int currentIndex = 0;
  private int maxSize = 5;
  private String delay = null;
  private Image[] images = new Image[maxSize];
  private Thread thread;

  public void init() {

    // load images into image array
    for (int i = 0; i < maxSize; i++) {
      String imageText = null;
      imageText = getParameter("image" + i);

      if (imageText != null) {
          imageIndex++;
          images[i] = getImage(getCodeBase(), imageText);
      } else break;
    }

    // get delay time
    delay = getParameter("delay");
    if (delay != null) {
      delayTimer = Integer.parseInt(delay);
    }
  }

  // draw images
  public void paint(Graphics graphics) {
    super.paint(graphics);
    Graphics2D graphics2D = (Graphics2D)graphics;

    if (images[currentIndex] != null) {
      graphics2D.drawImage(images[currentIndex], 0, 0, this);
    }
  }

  public void run() {
    Thread currentThread = Thread.currentThread();
    System.out.println("Thread Name: " + currentThread.getName());

    while (thread == currentThread) {

      repaint();      // display new image
      currentIndex++; // increment through the array

      if (currentIndex >= imageIndex) {
        currentIndex = 0;
      }

      try {
          Thread.sleep(delayTimer);  // delay between images
      } catch (InterruptedException exception) {
          System.err.println("run(): " + exception.getMessage());
      }
    }
  }

  public void start() {
    if (thread == null) {
      System.out.println("Creating New Thread");
      thread = new Thread(this);
      thread.start();
      System.out.println("Created New Thread: " + thread.getName());
    }
  }

  public void stop() {
   if (thread != null) {
      System.out.println("Destroying Thread: " + thread.getName());
      thread = null;
      System.out.println("Thread Destroyed");
    }
  }
}
