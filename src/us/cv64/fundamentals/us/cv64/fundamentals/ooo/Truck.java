package us.cv64.fundamentals.ooo;

public class Truck extends Vehicle {
  public Truck() {}

  private boolean fwd;
  private int torque;

  public boolean isFourWheel() { return fwd; }
  public int getTorque() { return torque; }
  public void setFourWheel( boolean  fwd ) {
    this.fwd = fwd;
  }
  public void setTorque( int torque ) {
    this.torque = torque;
  }
}