public class ClearerThis {
  
  // Accessor Methods
  public String getName() {
    return name_;
  }
  public String getAddress() {
    return address_;
  }

  public int getZipCode() {
    return zipCode_;
  }

  // Mutator Methods
  public void setName(String name) {
    name_ = name;
  }

  public void setAddress(String address) {
    address_ = address;
  }

  public void setZipCode(int zipCode) {
    zipCode_ = zipCode;
  }

  // Attributes
  private String name_ = "";
  private String address_ = "";
  private int zipCode_ = 0;
}