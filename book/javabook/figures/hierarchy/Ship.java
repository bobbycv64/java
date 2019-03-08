// Subclass Ship extending Superclass Vehicle
public class Ship extends Vehicle {
  
  // Four Argument Constructor calling super class
  public Ship(String name, int year, String model, int displacement) {
    super(name, year, model);
    displacement_ = displacement;
  }

  // Zero Argument Constructor
  public Ship() { this("", 0, "", 0); }

  // Accessor Method
  public int getDisplacement() { return displacement_; }

  // Mutator Methods
  public void setDisplacement(int displacement) {
    displacement_ = displacement;
  }

  public String toString() {
    return(super.toString() + " Displacement: " + displacement_);
  }

  // Attributes
  private int displacement_ = 0;
}