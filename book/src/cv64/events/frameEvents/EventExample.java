package cv64.events.frameEvents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

class EventExample extends FrameEvents implements ActionListener {

  public EventExample() {

    JButton eventButton = new JButton("Event Button Example");
    eventButton.addActionListener(this);
    getContentPane().add(eventButton);
    validate();
  }

  public void actionPerformed(ActionEvent actionEvent) {
    i_++;
    System.out.println(actionEvent.getActionCommand());

    if (i_ == 3) {
      dispose();
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    new EventExample();
  }

  private int i_ = 0;
}
