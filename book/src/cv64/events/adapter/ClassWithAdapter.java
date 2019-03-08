package cv64.events.adapter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClassWithAdapter extends WindowAdapter {

  public void windowClosing(WindowEvent windowEvent) {
    System.exit(0);
  }
}
