package swing.gridBagLayout;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *  class GridBagExample
 *
 *  This class demonstrates why the GridBagLayout manager object should be
 *  used over all the other layouts for large and complex projects.  Several
 *  institutions of education teach the other layouts but not the GridBagLayout,
 *  this is not only upsetting but sad.
 *
 *  THERE IS ONLY ONE LAYOUT REQUIRED WHEN USING THE GRIDBAGLAYOUT MANAGER,
 *  NOT SEVERAL WITH THE OTHER LAYOUTS.  THE GRIDBAGLAYOUT MANAGER KEEPS
 *  TRACK OF EACH COMPONENT.
 *
 *  This demonstration application is intended as a descriptive tour of
 *  how to implement the GridBagLayout manager.  The GridBagLayout manager
 *  is the most flexible and powerful layout manager.  To fully exploit this
 *  layout manager, you must really exercise the code and write your own.
 *  Another important point is that this layout manager works very closely
 *  with the GridBagConstraints object.
 *
 *  In general, the GridBagLayout manager divides the container into a series
 *  of grids arranged in rows an columns.  Each of the grids does not have to
 *  be the same size.  The manager IMPLICITLY determines the number of rows
 *  and columns.
 *
 *  Parameters are specified as constraints, constraining the components to
 *  certain sizes, locations, reactions to being resized, borders around the
 *  components and more.  The GridBagConstraints class is used to specify
 *  these constraints.
 *
 *  This example demonstrates how to use the layout manager and its associated
 *  constrains to manage a complex application.  This application creates
 *  four panels, each panel has a number of buttons.  Each panel has a default
 *  background color, and the buttons on the panel can be used to change the
 *  background color.  The four panels are added to the frame and are managed
 *  by a GridBagLayout manager and the associated GridBag constraints.  Each
 *  panel in turn, manages their own buttons with the same GridBagLayout
 *  manager, but with a different GridBagConstraint for each button.
 *
 *  Clicking on a button results in the title of the frame informing the
 *  client the name of the button pressed in addition to changing the color
 *  of the panels background.
 *
 *  NOTE:  This code is for educational purposes only.  There are many places
 *  where there are hard coded variables and the code could be far more
 *  modular and other classes could be added.
 *
 *  @author     RWE			      - RE
 *  @author     Dan Mazzola       - DM
 *
 *  @version    19991221RE - now an applet
 *  @version    19990511RE - uses Constraints class
 *  @version    19980210DM - uses new JDK 1.1 events and AWT features
 *  @version    19970330DM - used JDK 1.0 event handling
 */

public class GridBagExample extends Applet implements ActionListener {

// Declare objects that are visible to the entire class

  public GridBagLayout gridBagLayout = new GridBagLayout();

  // The panel containing the "blueish" buttons and the buttons.
  public Panel   bluesPanel        = new Panel();
  public Button  blueButton        = new Button("Blue");
  public Button  cyanButton        = new Button("Cyan");
  public Button  magentaButton     = new Button("Magenta");

  // The panel containing the "redish" buttons and the buttons.
  public Panel   redsPanel         = new Panel();
  public Button  redButton         = new Button("Red");
  public Button  pinkButton        = new Button("Pink");

  // The panel with the "color-blending" buttons and the buttons.
  public Panel   blendsPanel       = new Panel();
  public Button  darkerButton      = new Button("Darker");
  public Button  lighterButton     = new Button("Lighter");

  // The panel holding the "shades-of-gray" buttons and the buttons
  public Panel   graysPanel        = new Panel();
  public Button  whiteButton       = new Button("White");
  public Button  lightGrayButton   = new Button("LightGray");
  public Button  grayButton        = new Button("Gray");
  public Button  darkGrayButton    = new Button("DarkGray");
  public Button  blackButton       = new Button("Black");

  public GridBagExample() {}

  public void setScreen() {

    // Set properties of the bluesPanel
    //
    // Set the background color to the starting color and set the layout
    // manager to the class's GridBayLayout manager.
    //
    // Then constrain the buttons for the panel as documented below

    bluesPanel.setBackground(Color.blue);
    bluesPanel.setLayout(gridBagLayout);
    new Constraint(bluesPanel, blueButton,       0, 0);
    new Constraint(bluesPanel, cyanButton,       0, 1);
    new Constraint(bluesPanel, magentaButton,    0, 2);

    // Set properties of the graysPanel
    //
    // Set the background color to the starting color and set the layout
    // manager to the class's GridBayLayout manager.
    //
    // Then constrain the buttons for the panel as documented below

    graysPanel.setBackground(Color.lightGray);
    graysPanel.setLayout(gridBagLayout);
    new Constraint(graysPanel, whiteButton,      0, 0, 1, 1, 0.0, 0.0);
    new Constraint(graysPanel, lightGrayButton,  1, 0, 1, 1, 0.5, 0.5);
    new Constraint(graysPanel, grayButton,       2, 0, 1, 1, 3.0, 3.0);
    new Constraint(graysPanel, darkGrayButton,   3, 0, 1, 1, 0.5, 0.5);
    new Constraint(graysPanel, blackButton,      4, 0, 1, 1, 0.0, 0.0);

    // Set properties of the redsPanel
    //
    // Set the background color to the starting color and set the layout
    // manager to the class's GridBayLayout manager.
    //
    // Then constrain the buttons for the panel as documented below

    redsPanel.setBackground(Color.red);
    redsPanel.setLayout(gridBagLayout);

    new Constraint(redsPanel, redButton,         0, 0, 1, 1, 0.0, 3.0, 5, 0, 5, 0);
    new Constraint(redsPanel, pinkButton,        1, 1, 1, 1, 0.0, 3.0, 5, 0, 5, 0);

    // Set properties of the blendsPanel
    //
    // Set the background color to the starting color and set the layout
    // manager to the class's GridBayLayout manager.
    //
    // Then constrain the buttons for the panel as documented below

    blendsPanel.setBackground(Color.yellow);
    blendsPanel.setLayout(gridBagLayout);

    new Constraint(blendsPanel, darkerButton,    0, 0, 1, 1, 0.0, 0.0, 9, 9, 9, 9);
    new Constraint(blendsPanel, lighterButton,   1, 0, 1, 1, 0.0, 0.0, 9, 9, 9, 9);

    // Set properties of the Frame (this)
    //
    // Set the background color to the starting color and set the layout
    // manager to the class's GridBayLayout manager.
    //
    // Then constrain the buttons for the panel as documented below

    this.setBackground(Color.green);
    this.setLayout(gridBagLayout);

    new Constraint(this, bluesPanel,             0, 0, 1, 1);
    new Constraint(this, redsPanel,              1, 0, 1, 1, 1.0, 1.0);
    new Constraint(this, blendsPanel,            2, 0, 1, 1);
    new Constraint(this, graysPanel,             0, 1, 3, 1);
  }

  private void addListenerToButtons() {

    blueButton.addActionListener(this);
    cyanButton.addActionListener(this);
    magentaButton.addActionListener(this);
    redButton.addActionListener(this);
    pinkButton.addActionListener(this);
    darkerButton.addActionListener(this);
    lighterButton.addActionListener(this);
    whiteButton.addActionListener(this);
    lightGrayButton.addActionListener(this);
    grayButton.addActionListener(this);
    darkGrayButton.addActionListener(this);
    blackButton.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {

    if (e.getSource() instanceof Button) {
         String buttonLabel = e.getActionCommand();
//         frame_.setTitle("You pressed the " + buttonLabel + " Button");

      if      (buttonLabel.equals("Blue")) {
                 bluesPanel.setBackground(Color.blue);
                 bluesPanel.repaint();
      }
      else if (buttonLabel.equals("Cyan")) {
                 bluesPanel.setBackground(Color.cyan);
                 bluesPanel.repaint();
      }
      else if (buttonLabel.equals("Magenta")) {
                 bluesPanel.setBackground(Color.magenta);
                 bluesPanel.repaint();
      }
      else if (buttonLabel.equals("Red")) {
                 redsPanel.setBackground(Color.red);
                 redsPanel.repaint();
      }
      else if (buttonLabel.equals("Pink")) {
                 redsPanel.setBackground(Color.pink);
                 redsPanel.repaint();
      }
      else if (buttonLabel.equals("White")) {
                 graysPanel.setBackground(Color.white);
                 graysPanel.repaint();
      }
      else if (buttonLabel.equals("LightGray")) {
                 graysPanel.setBackground(Color.lightGray);
                 graysPanel.repaint();
      }
      else if (buttonLabel.equals("Gray")) {
                 graysPanel.setBackground(Color.gray);
                 graysPanel.repaint();
      }
      else if (buttonLabel.equals("DarkGray")) {
                 graysPanel.setBackground(Color.darkGray);
                 graysPanel.repaint();
      }
      else if (buttonLabel.equals("Black")) {
                 graysPanel.setBackground(Color.black);
                 graysPanel.repaint();
      }
      else if (buttonLabel.equals("Darker")) {
                 blendsPanel.setBackground(blendsPanel.getBackground().darker());
                 blendsPanel.repaint();
      }
      else if (buttonLabel.equals("Lighter")) {
                 blendsPanel.setBackground(blendsPanel.getBackground().brighter());
                 blendsPanel.repaint();
      }
    }
  }

  public void init() {

    setScreen();
    addListenerToButtons();
  }

  public static void main(String[] args) {

    Frame frame = new Frame("GridBagExample");
    GridBagExample gridBagExample = new GridBagExample();

    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) { System.exit(0); }
    });

    frame.setFont(new Font("Arial", Font.PLAIN, 24));
    frame.add("Center", gridBagExample);
    frame.setSize(400,200);
    frame.validate();
    frame.pack();
    frame.setVisible(true);

    gridBagExample.init();
    gridBagExample.start();
  }
}

