package us.cv64.swing.java3dxml.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import us.cv64.swing.gridBagLayout.Constraint;

public class CameraPanel extends JPanel implements ActionListener, ChangeListener {

  private JLabel title  = new JLabel("Camera");
  private JLabel labelX = new JLabel("X");
  private JLabel labelY = new JLabel("Y");
  private JLabel labelZ = new JLabel("Z");

  private JTextField textFieldX = new JTextField("0", 20);
  private JTextField textFieldY = new JTextField("0", 20);
  private JTextField textFieldZ = new JTextField("0", 20);

  private JSlider sliderX = new JSlider(JSlider.HORIZONTAL, -10, 10, 0);
  private JSlider sliderY = new JSlider(JSlider.HORIZONTAL, -10, 10, 0);
  private JSlider sliderZ = new JSlider(JSlider.HORIZONTAL, -10, 10, 0);

  private int counter = 0;

  public CameraPanel() {
    setDisplay();
    setListeners();
  }

  public void setDisplay() {
    this.setLayout(new GridBagLayout());
    this.setBackground(java.awt.Color.blue);

    new Constraint(this, title,      0, 0, 1, 1);
    new Constraint(this, sliderX,    2, 0, 1, 1);
    new Constraint(this, sliderY,    2, 1, 1, 1);
    new Constraint(this, sliderZ,    2, 2, 1, 1);

    new Constraint(this, labelX,     3, 0, 1, 1);
    new Constraint(this, labelY,     3, 1, 1, 1);
    new Constraint(this, labelZ,     3, 2, 1, 1);

    new Constraint(this, textFieldX, 4, 0, 1, 1);
    new Constraint(this, textFieldY, 4, 1, 1, 1);
    new Constraint(this, textFieldZ, 4, 2, 1, 1);
  }

  public void setListeners() {
    sliderX.addChangeListener(this);
    sliderY.addChangeListener(this);
    sliderZ.addChangeListener(this);

    textFieldX.addActionListener(this);
    textFieldY.addActionListener(this);
    textFieldZ.addActionListener(this);
  }

  public void actionPerformed(ActionEvent actionEvent) {
    System.out.println("actionPerformed() " + counter);

    if (actionEvent.getSource() == textFieldX) {
        textFieldX.setText(Integer.toString(counter++));
    } else if (actionEvent.getSource() == textFieldY) {
        textFieldY.setText(Integer.toString(counter++));
    } else if (actionEvent.getSource() == textFieldZ) {
        textFieldZ.setText(Integer.toString(counter++));
    }
  }

  public void stateChanged(ChangeEvent changeEvent) {
    System.out.println("stateChanged() ");
    JSlider sliderEvent = (JSlider)changeEvent.getSource();

    if (!sliderEvent.getValueIsAdjusting()) {
      if (changeEvent.getSource() == sliderX) {
          textFieldX.setText(Integer.toString(sliderEvent.getValue()));
      } else if (changeEvent.getSource() == sliderY) {
          textFieldY.setText(Integer.toString(sliderEvent.getValue()));
      } else if (changeEvent.getSource() == sliderZ) {
          textFieldZ.setText(Integer.toString(sliderEvent.getValue()));
      }
    }
  }
}
