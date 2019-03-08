package cv64.exceptions;

class Except3 {
  public int min = 0;
  public int max = 9;

  public Except3() {
    Except2 obj = new Except2();

    try {
      obj.rangeCheck(3);
      obj.rangeCheck(10); // exception thrown
      obj.rangeCheck(5); // not reached
    }
    catch (RangeException exception) {
      System.out.println("In catch: " + exception.getMessage());
      System.out.println(exception);
      System.out.println("Min: " + exception.min);
    }
    finally {
      System.out.println("In finally: Optional");
    }
  }

  public static void main(String[] args) {
    new Except3();
  }
}
