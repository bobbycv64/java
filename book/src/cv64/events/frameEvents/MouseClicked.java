package cv64.events.frameEvents;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

class MouseClicked extends JPanel {

  public MouseClicked() {


  addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent mouseEvent) {
        System.out.println("Mouse Pressed at x= " +
          mouseEvent.getX() + " y=" + mouseEvent.getY());
      }
    });
  }
}
