//Superclass to Aircraft, Automobile, Ship
public abstract class Vehicle {
  
  // Three Argument Constructor
  public Vehicle(String name, int year, String model) {
    name_ = name;
    year_ = year;
    model_ = model;
  }

  // Zero Argument Constructor
  public Vehicle() { this("", 0, ""); }

  // Accessor Methods
  public String getModel() { return model_; }
  public String getName()  { return name_; }
  public int getYear()     { return year_; }

  // Mutator Methods
  public void setModel(String model) { model_ = model; }
  public void setName(String name)   { name_ = name; }
  public void setYear(int year)      { year_ = year; }

  public String toString() {
    return("Name : " + name_ + " Year: " + year_ + " Model: " + model_);
  }

  // Attributes
  private String name_  = "";
  private String model_ = "";
  private int year_     = 0;
}