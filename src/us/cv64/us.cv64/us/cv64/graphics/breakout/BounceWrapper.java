package us.cv64.graphics.breakout;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * This Class creates a JFrame - a widget wrapper that contains all the widgets
 * for the program
 */
@SuppressWarnings("serial")
public class BounceWrapper extends JFrame {

	public final int PANEL_SIZE = 1500;
	public final int BORDER_SPACE = 0;
	public final int NUM_BLOCKS = 8;

	/**
	 * BounceWrapper no argument Constructor
	 */
	public BounceWrapper() {
		setSize(PANEL_SIZE / 2, PANEL_SIZE + BORDER_SPACE); // set size of JFrame
		add(new BouncePanel(PANEL_SIZE / 2, PANEL_SIZE, NUM_BLOCKS)); // calls the BouncePanel Constructor
		setResizable(false);
		setTitle("Blocks and balls"); // set title of the JFrame
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when X is pressed exit program
	}

	/**
	 * main method that starts the program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				// call BounceWrapper no argument Constructor
				BounceWrapper go = new BounceWrapper();
				go.setVisible(true);
			}
		});
	}

}