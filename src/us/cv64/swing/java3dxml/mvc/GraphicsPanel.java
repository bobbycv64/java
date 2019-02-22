package us.cv64.swing.java3dxml.mvc;

import java.awt.GridBagLayout;
import javax.swing.JPanel;

import net.java.games.jogl.GLCanvas;

import us.cv64.swing.gridBagLayout.Constraint;

public class GraphicsPanel extends JPanel {

  public GraphicsPanel(GLCanvas glCanvas) {

    this.setLayout(new GridBagLayout());
    this.setBackground(java.awt.Color.red);
    new Constraint(this, glCanvas, 0, 0);
  }
}
