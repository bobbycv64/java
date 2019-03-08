public class ClassWithoutAdapter implements WindowListener {

  public void windowActivated(WindowEvent windowEvent) {}
  public void windowClosed(WindowEvent windowEvent) {}

  public void windowClosing(WindowEvent windowEvent) {
    System.exit(0);
  }

  public void windowDeactivated(WindowEvent windowEvent) {}
  public void windowDeiconified(WindowEvent windowEvent) {}
  public void windowIconified(WindowEvent windowEvent) {}
  public void windowOpened(WindowEvent windowEvent) {}
}