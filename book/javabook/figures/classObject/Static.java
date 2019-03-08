public class Static {

  public Static() {
    numberOfInstances_++;
  }

  public static int getNumberOfInstances() {
    return numberOfInstances_;
  }

  private static int numberOfInstances_ = 0;
}