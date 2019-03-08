import java.awt.Container;

public class Calculator extends FrameEvents {

  public Calculator() {
    Container contentPane = this.getContentPane();
    contentPane.add(new CalculatorPanel());
  }
  
  public static void main(String[] args) {
    new Calculator();
  }
}