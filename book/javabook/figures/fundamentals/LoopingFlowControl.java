public class LoopingFlowControl {
  
  public static void main(String[] args) {

    int i = 0;

    // for loop example
    System.out.println("\nFor");
    for(int j = 0; j < 10; j++) {
      System.out.print(j);
    }

    // while example
    i = 0;
    System.out.println("\nWhile");
    while(i < 10) {
      System.out.print(i++);
    }

    // do while example
    i = 0;
    System.out.println("\nDo While");
    do {
      System.out.print(i++);
    } while(i < 10);
  }
}