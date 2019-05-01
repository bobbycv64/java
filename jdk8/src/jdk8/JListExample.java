package jdk8;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

public class JListExample extends JFrame {

	private static final long serialVersionUID = 1L;
	private JList<String> list = null;
	private String[] listColorNames = { "black", "blue", "green", "yellow", "white" };
	private Color[] listColorValues = { Color.BLACK, Color.BLUE, Color.GREEN, Color.YELLOW, Color.WHITE };
	private Container contentpane = null;

	public JListExample() {
		super("JList Example");
		contentpane = getContentPane();
		contentpane.setLayout(new FlowLayout());
		list = new JList<String>(listColorNames);
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentpane.add(new JScrollPane(list));
		list.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
				contentpane.setBackground(listColorValues[list.getSelectedIndex()]);
			}
		});
		setSize(200, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		JListExample test = new JListExample();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}