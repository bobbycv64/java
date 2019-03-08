package cv64.events.plafTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PlafPanel extends JPanel implements ActionListener {
  public PlafPanel() {
    metalButton = new JButton("Metal");
    motifButton = new JButton("Motif");
    windowsButton = new JButton("Windows");

    add(metalButton);
    add(motifButton);
    add(windowsButton);

    metalButton.addActionListener(this);
    motifButton.addActionListener(this);
    windowsButton.addActionListener(this);

    validate();
  }

  public void actionPerformed(ActionEvent event) {
    Object source = event.getSource();
    String plaf = "";
    if (source == metalButton) {
      plaf = "javax.swing.plaf.metal.MetalLookAndFeel";
      setBackground(Color.green);
    } else if (source == motifButton) {
      plaf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
      setBackground(Color.yellow);
    } else if (source == windowsButton) {
      plaf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
      setBackground(Color.red);
    }

    try {
      UIManager.setLookAndFeel(plaf);
      SwingUtilities.updateComponentTreeUI(this);
    } catch (Exception exception) {
        System.err.println(exception.getMessage());
    }
  }

  private JButton metalButton;
  private JButton motifButton;
  private JButton windowsButton;
}
