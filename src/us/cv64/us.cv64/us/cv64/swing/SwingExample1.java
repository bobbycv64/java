package us.cv64.swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class SwingExample1 extends JFrame {

	private static final long serialVersionUID = 7204044980348829366L;

	public SwingExample1() {
		getContentPane().setBackground(Color.WHITE);  // background color
		setTitle("Assignment 4");  // title bar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // close the frame
		setVisible(true);  // make the frame visible
		setResizable(false);  // cannot resize
		setSize(400, 300);  // width and height in pixels
		getContentPane().setLayout(new BorderLayout());  // set the layout in the frame
		
        drawWestButtons();
        
		JPanel center = new JPanel();
		center.setBackground(Color.GREEN);
        add(center, BorderLayout.CENTER);
        
		JPanel south = new JPanel();
		south.setBackground(Color.BLUE);
		south.setLayout(new GridLayout(3, 1));
        add(south, BorderLayout.SOUTH);
	}
	
	// drawWestButtons renders the 7 control buttons on the west panel
	private void drawWestButtons() {
		
		JPanel west = new JPanel(new GridLayout(7, 1));
		west.setBackground(Color.RED);
        add(west, BorderLayout.WEST);

        west.add(new JButton("Button 1"));
        west.add(new JButton("Button 2"));
        west.add(new JButton("Button 3"));
        west.add(new JButton("Button 4"));
        west.add(new JButton("Button 5"));
        west.add(new JButton("Button 6"));
        west.add(new JButton("Button 7"));
	}

	public static void main(String[] args) {
		new SwingExample1();
	}
}