package us.cv64.ooo;

public class Example {
  public static void main( String[] args ) {

    Vehicle car = new Vehicle();
    Truck ram = new Truck();
    Truck dakota = new Truck();

    car.setSpeed( 50 );
    ram.setSpeed( 100 );
    ram.setTorque( 5000 );
    dakota.setSpeed( 70 );

    System.out.println( "Car speed:    " + car.getSpeed() );
    System.out.println( "Ram speed:    " + ram.getSpeed() );
    System.out.println( "Ram Torque:   " + ram.getTorque() );
    System.out.println( "Dakota speed: " + dakota.getSpeed() );
  }
}