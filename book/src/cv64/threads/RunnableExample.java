package cv64.threads;

public class RunnableExample implements Runnable {

  Thread[] threads = new Thread[5];
  int index = 0;
  int maxThreadSize = 5;

  public void run() {
    Thread currentThread = Thread.currentThread();  // get the thread parameters

    for (int i=0; i < 10; i++) {
      System.out.println("Iteration: " + i + " of " + currentThread.getName());

      try {
          currentThread.sleep((long)(Math.random() * 1000));
      } catch (InterruptedException exception) {
          exception.getMessage();
          exception.getStackTrace();
      }
    }

    System.out.println("End of Thread: " + currentThread.getName());
  }

  public void start() {
      if (index >= maxThreadSize) System.exit(-1);
      threads[index] = new Thread(this);  // create a new thread
      threads[index].start();             // call the run method for the thread
      index++;
  }

  public static void main(String[] args) {

    RunnableExample runnableExample = new RunnableExample();
    runnableExample.start();
    runnableExample.start();
  }
}
