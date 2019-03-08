package cv64.classObject;

public class Accessibility {

  // Anyone can access these items
  public Accessibility() {}
  public void anyoneCanUseMe() {}
  public int anyoneCanUseMe_ = 0;

  // Only the object of this type can access these items
  private Accessibility(int someInteger) {}
  private void onlyAccessibilityCanUseMe() {}
  private int onlyAccessibilityCanUseMe_ = 0;
}
