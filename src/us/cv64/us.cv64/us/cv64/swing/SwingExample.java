package us.cv64.swing;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

//import com.mkyong.dynamicshapes.DynamicShapes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingExample extends JFrame {

	private static final long serialVersionUID = 7204044980348829366L;
	JPanel north = new JPanel(new GridLayout(1, 3));

	public SwingExample() {
		getContentPane().setBackground(Color.BLUE);  // background color
		setTitle("TCSS 305 - Paint Program");  // title bar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // close the frame
		setVisible(true);  // make the frame visible
		setResizable(true);  // cannot resize
		setSize(400, 300);  // width and height in pixels
		getContentPane().setLayout(new BorderLayout());  // set the layout in the frame
		final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        final int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
		
        
        drawMenuBar();
        
        drawCenterPanel();
		
		
	}
	private void drawMenuBar() {
	    JMenuBar menuBar = new JMenuBar();
	    JMenu options= new JMenu("Options");
	    JMenu tools= new JMenu("Tools");
	    JMenu help= new JMenu("Help");
	    JMenu thickness = new JMenu("Thickness");
	    JMenuItem color = new JMenuItem("Color...");
	    JMenuItem clear = new JMenuItem("Clear");
	    JMenuItem about = new JMenuItem("About");
	    options.add(thickness);
	    options.add(color);
	    options.add(clear);
	    tools.add(toolsPanel());
	    menuBar.add(options);
	    menuBar.add(tools);
	    menuBar.add(help);
	    help.add(about);
	    north.add(menuBar);
	    add(north);//this should be fix
	    revalidate();
	    pack();
	    thickness.add(drawSlider());
	    add(toolBar(), BorderLayout.SOUTH);
	    
	    /*
	    thickness.addMenuListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                System.out.println("Thickness");
                thickness.add(drawSlider());
                revalidate();
                pack();
            }
        });*/
	    
	    color.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                System.out.println("Color");
                                
            }
        });
	    clear.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                System.out.println("Clear");
                                
            }
        });
	    
	    about.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent actionEvent) {
                System.out.println("about");
                aboutMenu();
                                
            }
        });
        
	  
	    
	    
	}
	private void toolsMenu() {
	    
	}
	
	private void drawNorthButtons() {	
	    
		north.setBackground(Color.RED);
        add(north, BorderLayout.NORTH);
        north.add(new JButton("Options"));
        north.add(new JButton("Tools"));
        north.add(new JButton("Help"));
      
	}
	private void toolBarOption() {
	    JMenuBar menuBar = new JMenuBar();
	    JMenu optionsMenu, toolsMenu, helpMenu;
	      
	    optionsMenu = new JMenu("Options");
	    toolsMenu = new JMenu("Tools");
	    helpMenu = new JMenu("Help");
	      
	    JRadioButtonMenuItem lineMenuItem, pencilMenuItem, rectangleMenuItem, elipseMenuItem;
	    ImageIcon lineIcon, pencilIcon, rectangleIcon, elipseIcon;
	      
	    lineIcon = new ImageIcon("line.gif");
	    lineMenuItem = new JRadioButtonMenuItem("Line", lineIcon);
	      
	    pencilIcon = new ImageIcon("pencil.gif");
	    pencilMenuItem = new JRadioButtonMenuItem("Pencil", pencilIcon);
	      
	    rectangleIcon = new ImageIcon("rectangle.gif");
	    rectangleMenuItem = new JRadioButtonMenuItem("Rectangle", rectangleIcon);
	      
	    elipseIcon = new ImageIcon("elipse.gif");
	    elipseMenuItem = new JRadioButtonMenuItem("Elipse", elipseIcon);
	      
	    ButtonGroup menuItemsButtonGroup = new ButtonGroup();
	    menuItemsButtonGroup.add(lineMenuItem);
	    menuItemsButtonGroup.add(pencilMenuItem);
	    menuItemsButtonGroup.add(rectangleMenuItem);
	    menuItemsButtonGroup.add(elipseMenuItem);
	      
	    toolsMenu.add(lineMenuItem);
	    toolsMenu.add(pencilMenuItem);
	    toolsMenu.add(rectangleMenuItem);
	    toolsMenu.add(elipseMenuItem);
	      
	    menuBar.add(optionsMenu);
	    menuBar.add(toolsMenu);
	    menuBar.add(helpMenu);
	      
	    this.setJMenuBar(menuBar);
	}
	private JToolBar toolBar() {
	    JToolBar toolBar = new JToolBar(); 
	    toolBar.setRollover(true);
	    
	    toolBar.add(new JButton("Color"));
	    toolBar.add(new JButton("Line"));
	    toolBar.add(new JButton("Pencil"));
	    toolBar.add(new JButton("Rectangle"));
	    toolBar.add(new JButton("Ellipse"));
	   
	    return toolBar;
	    
	}
	
	private JPanel toolsPanel() {
	    JPanel panel = new JPanel();
	    panel.setLayout(new GridLayout(4,1));	 
	    JRadioButtonMenuItem lineMenuItem, pencilMenuItem, rectangleMenuItem, elipseMenuItem;
        ImageIcon lineIcon, pencilIcon, rectangleIcon, elipseIcon;
          
        lineIcon = new ImageIcon("line.gif");
        lineMenuItem = new JRadioButtonMenuItem("Line", lineIcon);
          
        pencilIcon = new ImageIcon("pencil.gif");
        pencilMenuItem = new JRadioButtonMenuItem("Pencil", pencilIcon);
          
        rectangleIcon = new ImageIcon("rectangle.gif");
        rectangleMenuItem = new JRadioButtonMenuItem("Rectangle", rectangleIcon);
          
        elipseIcon = new ImageIcon("elipse.gif");
        elipseMenuItem = new JRadioButtonMenuItem("Elipse", elipseIcon);
          
        ButtonGroup menuItemsButtonGroup = new ButtonGroup();
        menuItemsButtonGroup.add(lineMenuItem);
        menuItemsButtonGroup.add(pencilMenuItem);
        menuItemsButtonGroup.add(rectangleMenuItem);
        menuItemsButtonGroup.add(elipseMenuItem);
          
        panel.add(lineMenuItem);
        panel.add(pencilMenuItem);
        panel.add(rectangleMenuItem);
        panel.add(elipseMenuItem);
        return panel;
	}
	private void drawSouthButton() {
	    JPanel south = new JPanel();
        south.setBackground(Color.BLUE);
        south.setLayout(new GridLayout(1, 8));
        add(south, BorderLayout.SOUTH);
        south.add(new JButton("Color"));
        south.add(new JButton("Line"));
        south.add(new JButton("Pencil"));
        south.add(new JButton("Rectangle"));
        south.add(new JButton("Ellipse"));
	}

	private void drawCenterPanel() {
	    JPanel center = new JPanel();
        center.setBackground(Color.GREEN);
        add(center, BorderLayout.CENTER);
        String shapeAmount=JOptionPane.showInputDialog(null, "How many shapes?", "Random Shapes...", JOptionPane.PLAIN_MESSAGE); 
        int amount=Integer.parseInt(shapeAmount);
        
        String shapes[]={"Stars", "Circles", "Both"};
        String shape=(String)JOptionPane.showInputDialog(null, "Pick the shape you want", "Random Shapes...", JOptionPane.PLAIN_MESSAGE, null, shapes,shapes[0]);
                
        //center.add(new DynamicShapes(amount, shape));
        revalidate(); 
        pack();
	}
	
	private JSlider drawSlider() {
	    JSlider slider = new JSlider(JSlider.HORIZONTAL,0,15,1);
	    slider.setMajorTickSpacing(5);
	    slider.setMinorTickSpacing(1);
	    slider.setPaintTicks(true);
	    slider.setPaintLabels(true);
	    
	    return slider;
	}
	
	private void aboutMenu() {
	    JOptionPane.showMessageDialog(null, "Autumn 2018" + "\n" + "Evan Luputra", 
	                                  "TCSS 305 - Paint Program", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void main(String[] args) {
		new SwingExample();
	}
}