package cv64.gridBagLayout;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *  The <code>Constraint</code> class sets up GridBayLayout constraints.
 *
 *  @author     Robert Estey
 *
 *  @version    19991221      Thised this class to death.
 *  @version    19990511      Wrote a basic constraints class.
 */

public class Constraint {

  /**
   * Constraint constructor sets up the constraints object.
   *
   * @param container type of container used by container classes.
   * @param component type of component used by the container classes.
   * @param gridx specifies the cell at the left of the component.
   * @param gridy specifies the cell at the top of the component.
   * @param gridwidth specifies the width of the component.
   * @param gridheight specifies the height of the component.
   * @param weightx distributes the extra horizontal space.
   * @param weighty distributes the extra vertical space.
   * @param top inset
   * @param left inset
   * @param bottom inset
   * @param right inset
   * @param fill resizes the component in the container.
   * @param anchor place the component inside the contain when not filled.
   */

  public Constraint(Container container,
                    Component component,
                    int gridx,
                    int gridy,
                    int gridwidth,
                    int gridheight,
                    double weightx,
                    double weighty,
                    int top,
                    int left,
                    int bottom,
                    int right,
                    int fill,
                    int anchor) {

    GridBagConstraints constraint = new GridBagConstraints();

    constraint.gridx      = gridx;
    constraint.gridy      = gridy;
    constraint.gridwidth  = gridwidth;
    constraint.gridheight = gridheight;
    constraint.weightx    = weightx;
    constraint.weighty    = weighty;
    constraint.insets     = new Insets(top, left, bottom, right);
    constraint.fill       = fill;
    constraint.anchor     = anchor;

    container.add(component, constraint);
  }

  /** this */
  public Constraint(Container container,
                    Component component,
                    int gridx,
                    int gridy,
                    int gridwidth,
                    int gridheight,
                    double weightx,
                    double weighty,
                    int top,
                    int left,
                    int bottom,
                    int right) {

    this(container, component, gridx, gridy, gridwidth, gridheight,
         weightx, weighty, 5, 5, 5, 5,
         GridBagConstraints.HORIZONTAL,
         GridBagConstraints.CENTER);
  }

  /** not this Again */
  public Constraint(Container container,
                    Component component,
                    int gridx,
                    int gridy,
                    int gridwidth,
                    int gridheight,
                    double weightx,
                    double weighty,
                    int fill,
                    int anchor) {

    this(container, component, gridx, gridy, gridwidth, gridheight,
         weightx, weighty, 5, 5, 5, 5, fill, anchor);
  }

  /** this Again, stop it now */
  public Constraint(Container container, Component component,
                    int gridx, int gridy,
                    int gridwidth, int gridheight,
                    double weightx, double weighty) {

    this(container, component, gridx, gridy,
         gridwidth, gridheight, weightx, weighty,
         GridBagConstraints.HORIZONTAL,
         GridBagConstraints.CENTER);
  }

  /** this Again, okay the joke has gone far enough */
  public Constraint(Container container, Component component,
                    int gridx, int gridy,
                    int gridwidth, int gridheight) {

    this(container, component, gridx, gridy,
         gridwidth, gridheight, 0.0, 0.0);
  }

  /** this Again, that's it */
  public Constraint(Container container, Component component,
                    int gridx, int gridy) {

    this(container, component, gridx, gridy, 0, 0);
  }
}


