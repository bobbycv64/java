package cv64.interfaces;

// Inner Class Example
public class InnerClassExample {

  public static void main(String[] args) {

    OuterClass outerClass = new OuterClass();
    JavaBean javaBean = outerClass.getInnerClass();
    javaBean.set("Inner Class Example");
    System.out.println("Inner Class Value: " + javaBean.get());
  }
}
