package jdk8;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

// JFrame is the title bar and the thin line encapsulating the GUI
public class GridBagLayoutExample extends JFrame {

	public static void main(String[] args) {
		new GridBagLayoutExample();
	}

	public GridBagLayoutExample() {
		setSize(300, 300); // Set the size of the JFrame
		setPreferredSize(getSize());
		setVisible(true); // Set the JFrame to be visible
		setDefaultCloseOperation(EXIT_ON_CLOSE); // close when exit is selected
		GridBagLayout g = new GridBagLayout(); // use GridBagLayout layout manager
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(g);
		setTitle("GridBag Layout");

		GridBagLayout layout = new GridBagLayout();

		this.setLayout(layout);

		// set Button widgets on GridBagLayout
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(new Button("Button 1"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(new Button("Button 2"), gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 20;
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(new Button("Button 3"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(new Button("Button 4"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 2;
		this.add(new Button("Button 5"), gbc);
	}
}
