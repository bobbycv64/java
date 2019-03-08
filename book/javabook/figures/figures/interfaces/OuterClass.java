// Inner Class Example
public class OuterClass {

  public JavaBean getInnerClass() {
    return new InnerClass();
  }

  private class InnerClass implements JavaBean {
    public String get() { return value_; }
    public void set(String value) { value_ = value; }
  }

  private String value_;
}