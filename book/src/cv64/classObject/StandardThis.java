package cv64.classObject;

public class StandardThis {

  // Accessor Methods
  public String getName() {
    return name;
  //return this.name; // alternate syntax
  }
  public String getAddress() {
    return address;
    //return this.address; // alternate syntax
  }

  public int getZipCode() {
    return zipCode;
  //return this.zipCode; // alternate syntax
  }

  // Mutator Methods
  public void setName(String name) {
    name = name;
  //this.name = name;  // alternate syntax
  }

  public void setAddress(String address) {
    address = address;
  //this.address = address;  // alternate syntax
  }

  public void setZipCode(int zipCode) {
    zipCode = zipCode;
  //this.zipCode = zipCode;  // alternate syntax
  }

  // Attributes
  private String name = "";
  private String address = "";
  private int zipCode = 0;
}
