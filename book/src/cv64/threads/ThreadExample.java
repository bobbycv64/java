package cv64.threads;

public class ThreadExample extends Thread {

  public ThreadExample(String string) {
    super(string);
  }

  public void run() {
    for (int i=0; i < 10; i++) {
      System.out.println("Iteration: " + i + " of " + getName());

      try {
          sleep((long)(Math.random() * 1000));
      } catch (InterruptedException exception) {
          exception.getMessage();
          exception.getStackTrace();
      }
    }

    System.out.println("End of Thread: " + getName());
  }

  public static void main(String[] args) {

    // create new threads
    new ThreadExample("Thread One").start();
    new ThreadExample("Thread Two").start();
  }
}

