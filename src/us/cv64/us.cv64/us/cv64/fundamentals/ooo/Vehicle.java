package us.cv64.fundamentals.ooo;

public class Vehicle {
  
  private int speed;
  private int weight;  

  public Vehicle() {
    this.weight = 0;
  }

  public Vehicle( int speed ) {
    this();
    this.speed = speed;
  }

  public int getSpeed() { return speed; }
  public int getWeight() { return weight; }
  public void setSpeed( int speed ) {
    this.speed = speed;
  }
  public void setWeight( int weight ) {
    this.weight = weight;
  }
}