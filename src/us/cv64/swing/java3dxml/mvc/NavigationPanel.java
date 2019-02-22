package us.cv64.swing.java3dxml.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import us.cv64.swing.gridBagLayout.Constraint;

public class NavigationPanel extends JPanel implements ActionListener, ChangeListener {

  private JButton button = new JButton("Some Button");
  private JLabel label = new JLabel("Some Label");
  private JTextField textField = new JTextField("Some Text", 20);
  private JSlider slider = new JSlider(JSlider.HORIZONTAL, -3, 3, 0);

  private int counter = 0;

  public NavigationPanel() {

    this.setLayout(new GridBagLayout());

    CameraPanel cameraPanel = new CameraPanel();
    JPanel panel3 = new JPanel();

    panel3.setLayout(new GridBagLayout());

    panel3.setBackground(java.awt.Color.cyan);


    new Constraint(panel3, label,      0, 0, 1, 1);
    new Constraint(panel3, button,     1, 0, 1, 1);
    new Constraint(panel3, slider,     0, 1, 1, 1);
    new Constraint(panel3, textField,  1, 1, 1, 1);

    new Constraint(this,   cameraPanel,  4, 0, 3, 5);
    new Constraint(this,   panel3,       4, 5, 2, 2);
  }

  public void actionPerformed(ActionEvent actionEvent) {
    System.out.println("actionPerformed() " + counter);
    textField.setText(Integer.toString(counter++));
  }

  public void stateChanged(ChangeEvent changeEvent) {
    System.out.println("stateChanged() ");
    JSlider sliderEvent = (JSlider)changeEvent.getSource();

    if (!sliderEvent.getValueIsAdjusting()) {
      textField.setText(Integer.toString(sliderEvent.getValue()));
    }
  }
}
