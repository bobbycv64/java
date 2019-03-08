package cv64.events.multicast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

class MulticastPanel extends JPanel implements ActionListener {

  public MulticastPanel() {
    JButton newFrame = new JButton("New Frame");
    add(newFrame);
    newFrame.addActionListener(this);
    closeFrames_ = new JButton("Close All Frames");
    add(closeFrames_);
    validate();
  }

  public void actionPerformed(ActionEvent event) {
    ExitFrame frame = new ExitFrame();
    i_++;
    int coordinate = 100 + (i_ * 50);
    frame.setTitle("Frame " + i_);
    frame.setSize(100, 100);
    frame.setLocation(coordinate, coordinate);
    frame.setVisible(true);
    closeFrames_.addActionListener(frame);
  }

  private int i_ = 0;
  private JButton closeFrames_;
}
