/**
   @version 1.30 2000-05-12
   @author Cay Horstmann, not Nancy Wilson
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator
{
   public static void main(String[] args) {
      CalculatorFrame frame = new CalculatorFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.show();  
   }
}

/**
   A frame with a calculator panel.
*/
class CalculatorFrame extends JFrame
{
   public CalculatorFrame()
   {
      setTitle("Calculator");
      setSize(WIDTH, HEIGHT);
      setMenu();

      Container contentPane = getContentPane();
      CalculatorPanel panel = new CalculatorPanel();
      contentPane.add(panel);

   }


// put the About button and Exit button on the menubar

    public void setMenu() {
    JMenuBar jmenuBar = new JMenuBar();
    JMenu jmenu = new JMenu("Look Here");
    JMenuItem aboutItem = new JMenuItem("About Me");
    JMenuItem exitItem = new JMenuItem("Exit");

     aboutItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        dialog = new AboutDialog(CalculatorFrame.this);
        dialog.show();
      }
     });

    exitItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        System.exit(0);
      }
    });

    jmenu.add(aboutItem);
    jmenu.add(exitItem);
    jmenuBar.add(jmenu);
    setJMenuBar(jmenuBar);

    }

   public static final int WIDTH = 200;
   public static final int HEIGHT = 200; 



   //private DialogTest dialog; 
   private Dialog dialog;
}


// starting here I'm pasting in the class About Dialog

class AboutDialog extends JDialog
{  
   public AboutDialog(JFrame owner)
   {  
      super(owner, "About Calculator", true);         
      Container contentPane = getContentPane();

      // add HTML label to center

      contentPane.add(new JLabel(
         "<HTML>Nancy Wilson<br>"
         + "swiped the Calculator program from the book</HTML>"),
         BorderLayout.CENTER);

      // Ok button closes the dialog
      
      JButton ok = new JButton("Ok");
      ok.addActionListener(new 
         ActionListener() 
         {  
            public void actionPerformed(ActionEvent evt) 
            { 
               setVisible(false); 
            } 
         });

      // add Ok button to southern border
      
      JPanel panel = new JPanel();
      panel.add(ok);
      contentPane.add(panel, BorderLayout.SOUTH);

      setSize(250, 150);
   }
}


// pasting ends here


/**
   A panel with calculator buttons and a result display.
*/
class CalculatorPanel extends JPanel
{  
   public CalculatorPanel()
   {  
      setLayout(new BorderLayout());

      result = 0;
      lastCommand = "=";
      start = true;
      
      // add the display

      display = new JTextField("0");
      display.setEditable(false);
      add(display, BorderLayout.NORTH);
      
      ActionListener insert = new InsertAction();
      ActionListener command = new CommandAction();

      panel = new JPanel();
    
      // add the buttons in a 4 x 4 grid

      panel.setLayout(new GridLayout(4, 4));

      addButton("7", insert);
      addButton("8", insert);
      addButton("9", insert);
      addButton("/", command);

      addButton("4", insert);
      addButton("5", insert);
      addButton("6", insert);
      addButton("*", command);

      addButton("1", insert);
      addButton("2", insert);
      addButton("3", insert);
      addButton("-", command);

      addButton("0", insert);
      addButton(".", insert);
      addButton("=", command);
      addButton("+", command);

      add(panel, BorderLayout.CENTER);
   }

   /**
      Adds a button to the center panel.
      @param label the button label
      @param listener the button listener
   */
   private void addButton(String label, ActionListener listener)
   {  
      JButton button = new JButton(label);
      button.addActionListener(listener);
      panel.add(button);
   }

   /**
      This action inserts the button action string to the
      end of the display text.
   */
   private class InsertAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         String input = event.getActionCommand();
         if (start) 
         {
            display.setText("");
            start = false;
         }
         display.setText(display.getText() + input);
      }
   }

   /**
      This action executes the command that the button
      action string denotes.
   */
   private class CommandAction implements ActionListener
   {
      public void actionPerformed(ActionEvent evt)
      {  
         String command = evt.getActionCommand();

         if (start)
         {  
            if (command.equals("-")) 
            { 
               display.setText(command); 
               start = false; 
            }
            else 
               lastCommand = command;
         }
         else
         {  
            calculate(Double.parseDouble(display.getText()));
            lastCommand = command;
            start = true;
         }
      }
   }

   /**
      Carries out the pending calculation. 
      @param x the value to be accumulated with the prior result.
   */
   public void calculate(double x)
   {
      if (lastCommand.equals("+")) result += x;
      else if (lastCommand.equals("-")) result -= x;
      else if (lastCommand.equals("*")) result *= x;
      else if (lastCommand.equals("/")) result /= x;
      else if (lastCommand.equals("=")) result = x;
      display.setText("" + result);
   }

   private JTextField display;
   private JPanel panel;
   private double result;
   private String lastCommand;
   private boolean start;

}


