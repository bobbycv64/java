public class SwitchFlowControl {
  
  public static void main(String[] args) {

    for(int i = 0; i < 6; i++) {

      switch(i) {
        case 0:
          System.out.println("Case 0: " + i);
        break;

        case 1:
          System.out.println("Case 1: " + i);
        break;

        case 2:
        case 3:
          System.out.println("Case 2 or 3: " + i);
        break;

        case 4:
        default:
          System.out.println("Case 4 or other values: " + i);
        break;
      }
    }
  }
}