package cv64.events.multicast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

class ExitFrame extends JFrame implements ActionListener {

  public ExitFrame() {
    JButton button = new JButton("Exit");
    getContentPane().add(button);
    button.addActionListener(this);
  }

  public void actionPerformed(ActionEvent actionEvent) {
    dispose();
  }
}
