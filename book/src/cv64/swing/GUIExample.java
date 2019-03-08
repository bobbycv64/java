/**
 * @author Robert Estey
 * @version 1.0
 */
package cv64.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUIExample extends JPanel implements ActionListener, ChangeListener {

  private JButton button1 = new JButton("Some Button");
  private JButton button2 = new JButton("Another Button");
  private JLabel label = new JLabel("Some Label");
  private JTextField textField = new JTextField("Some Text", 20);
  private JSlider slider = new JSlider(JSlider.HORIZONTAL, -3, 3, 0);

  private int counter = 1;

  public GUIExample() {

    this.setLayout(new BorderLayout());

    this.add(button1, BorderLayout.SOUTH);
    this.add(label, BorderLayout.WEST);
    this.add(textField, BorderLayout.CENTER);

    this.setLayout(new GridLayout(3, 2));

    this.add(label);
    this.add(textField);
    this.add(button1);
    this.add(button2);
    this.add(slider);

    slider.setMajorTickSpacing(1);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);

    button1.addActionListener(this);
    button2.addActionListener(this);
    slider.addChangeListener(this);
  }

  public void actionPerformed(ActionEvent actionEvent) {
    System.out.println("actionPerformed() " + counter);
    textField.setText(Integer.toString(counter++));

    if (actionEvent.getSource().equals(button1)) {
      System.out.println("Button 1 Pressed");
    } else if (actionEvent.getSource().equals(button2)) {
        System.out.println("Button 2 Pressed");
    }
  }

  public void stateChanged(ChangeEvent changeEvent) {
    System.out.println("stateChanged() ");
    JSlider sliderEvent = (JSlider)changeEvent.getSource();

    if (!sliderEvent.getValueIsAdjusting()) {
      textField.setText(Integer.toString(sliderEvent.getValue()));
    }
  }

  public static void main(String[] args) {
    GUIExample guiExample = new GUIExample();  // create JPanel
    JFrame frame = new JFrame("GUI Example");  // create JFrame

    // close window if exit button pressed
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // add JPanel to JFrame
    frame.getContentPane().add("Center", guiExample);
    frame.pack();
    frame.setSize(new Dimension(400,300));
    frame.setVisible(true);
  }
}
