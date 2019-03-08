package us.cv64.swing.java3dxml.mvc;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import net.java.games.jogl.GLCanvas;

import us.cv64.swing.gridBagLayout.Constraint;

public class J3XModel extends JPanel {

  public J3XModel(GLCanvas glCanvas) {

    this.setLayout(new GridBagLayout());

    GraphicsPanel graphicsPanel = new GraphicsPanel(glCanvas);
    NavigationPanel navigationPanel = new NavigationPanel();

    new Constraint(this, graphicsPanel,   0, 0, 4, 7);
    new Constraint(this, navigationPanel, 4, 0, 5, 7);
  }
}
