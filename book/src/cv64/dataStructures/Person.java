package cv64.dataStructures;

public class Person {

  public Person(String name, String ssn) {
    name_ = name;
    ssn_ = ssn;
  }

  public String getName() { return name_; }
  public String getSSN() { return ssn_; }

  private String name_ = "";
  private String ssn_ = "";
}
