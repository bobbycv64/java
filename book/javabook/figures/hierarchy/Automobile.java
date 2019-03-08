// Subclass Automobile extending Superclass Vehicle
public class Automobile extends Vehicle {
  
  // Four Argument Constructor calling super class
  public Automobile(String name, int year, String model, int horsePower) {
    super(name, year, model);
    horsePower_ = horsePower;
  }

  // Three Argument Constructor using this
  public Automobile(String name, int year, String model) {
    this(name, year, model, 0);
  }

  // Zero Argument Constructor
  public Automobile() { this("", 0, "", 0); }

  // Accessor Method
  public int getHorsePower() { return horsePower_; }

  // Mutator Methods
  public void setHorsePower(int horsePower) {
    horsePower_ = horsePower;
  }

  public String toString() {
    return(super.toString() + " Horse Power: " + horsePower_);
  }

  // Attributes
  private int horsePower_ = 0;
}