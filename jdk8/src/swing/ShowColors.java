// http://www.java2s.com/example/java/swing/choosing-colors-with-jcolorchooser.html
package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

class ShowColor extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JButton changeColorJButton;
	private Color color = Color.LIGHT_GRAY;
	private final JPanel colorJPanel;

	public ShowColor() {
		super("Using JColorChooser");

		// create JPanel for display color
		colorJPanel = new JPanel();
		colorJPanel.setBackground(color);

		// set up changeColorJButton and register its event handler
		changeColorJButton = new JButton("Change Color");

		// define action listener, pass the event e inside the body
		changeColorJButton.addActionListener(e -> {

			color = JColorChooser.showDialog(ShowColor.this, "Choose a color", color);

			// set default color, if no color is returned
			if (color == null)
				color = Color.LIGHT_GRAY;

			// change content pane's background color
			colorJPanel.setBackground(color);
		});

		add(colorJPanel, BorderLayout.CENTER);
		add(changeColorJButton, BorderLayout.SOUTH);

		setSize(400, 130);
		setVisible(true);
	}
}

public class ShowColors {

	public static void main(String[] args) {
		ShowColor application = new ShowColor(); // call the Constructor
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit Swing
	}
}
