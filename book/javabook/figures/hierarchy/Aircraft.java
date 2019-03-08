// Subclass Aircraft extending Superclass Vehicle
public class Aircraft extends Vehicle {
  
  // Four Argument Constructor calling super class
  public Aircraft(String name, int year, String model, int thrust) {
    super(name, year, model);
    thrust_ = thrust;
  }

  // Zero Argument Constructor
  public Aircraft() { this("", 0, "", 0); }

  // Accessor Methods
  public int getThrust() { return thrust_; }

  // Mutator Methods
  public void setThrust(int thrust) {
    thrust_ = thrust;
  }

  public String toString() {
    return(super.toString() + " Thrust: " + thrust_);
  }

  // Attributes
  private int thrust_ = 0;
}