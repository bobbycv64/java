package us.cv64.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Store extends JFrame {

	private DecimalFormat decimalFormat = new DecimalFormat("$#.##");
	private static final String DIALOG_TITLE = "Summary Statistics";
	private JTable table = null;
	private String data[][] = null;
	private String columnNames[] = { "WebAd Price", "Discount", "Tax", "Total" };
	private DefaultTableModel defaultTableModel = new DefaultTableModel(data, columnNames);
	private List<WebAd> cart = new ArrayList<>();
	private String statistics = "Blank Message";

	private GridLayout gridLayout = new GridLayout(2, 3);
	private JButton addWebAd = new JButton("Add WebAd");
	private JButton removewebAd = new JButton("Remove Selected Ad");
	private JButton showStats = new JButton("Show Stats");
	private JButton viewAd = new JButton("View Selected Ad");
	private JButton printAd = new JButton("Print Selected Ad");
	private JButton mysteryBonus = new JButton("Mystery Bonus");
	private JLabel label = new JLabel(computeTotal());

	public Store() {

		table = new JTable(defaultTableModel);
		table.setBounds(30, 40, 200, 300);
		JScrollPane scrollPane = new JScrollPane(table);

		JPanel panel = new JPanel();

		panel.add(addWebAd);
		panel.add(removewebAd);
		panel.add(showStats);
		panel.add(viewAd);
		panel.add(printAd);
		panel.add(mysteryBonus);

		label.setPreferredSize(new Dimension(100, 50));
		label.setAlignmentX(CENTER_ALIGNMENT);
		label.setAlignmentY(CENTER_ALIGNMENT);
		panel.setLayout(gridLayout);

		this.add(scrollPane, BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
		this.add(label, BorderLayout.EAST);

		addListeners();
	}

	private void addListeners() {
		addWebAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				WebAd webAd = new WebAd();
				cart.add(webAd);
				String[] row = webAd.getTableRow();
				defaultTableModel.addRow(new Object[] { row[0], row[1], row[2], row[3] });
				label.setText(computeTotal());
			}
		});

		removewebAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				WebAd webAd = new WebAd();
				int selectedRow = table.getSelectedRow();

				if (selectedRow == -1)
					return;
				cart.remove(selectedRow);
				defaultTableModel.removeRow(selectedRow);
				label.setText(computeTotal());
			}
		});

		showStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane.showMessageDialog(null, computeStatistics(), DIALOG_TITLE, JOptionPane.PLAIN_MESSAGE);
			}
		});

		viewAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {

				int selectedRow = table.getSelectedRow();

				if (selectedRow == -1)
					return;

				String displayPrice = decimalFormat.format(cart.get(selectedRow).getUnitPrice());
				JLabel adPrice = new JLabel("Ad Price: " + displayPrice);
				DrawToolPanel panel = new DrawToolPanel(displayPrice);
				//panel.setBackground(Color.BLUE);

				JFrame newFrame = new JFrame();
				newFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				newFrame.setSize(200, 200);
				newFrame.setTitle("WebAd " + selectedRow);
				newFrame.add(adPrice);
				newFrame.add(panel);
				newFrame.setContentPane(panel);
				newFrame.setVisible(true);
			}
		});
	}

	private String computeStatistics() {

		String string = "";
		double lowPrice = 0;
		double highPrice = 0;
		double averagePrice = 0;
		double unitPrice = 0;

		for (int i = 0; i < cart.size(); i++) {
			unitPrice = cart.get(i).getUnitPrice();

			averagePrice += unitPrice;

			if (i == 0) {
				lowPrice = unitPrice;
				highPrice = unitPrice;
			} else if (lowPrice > unitPrice) {
				lowPrice = unitPrice;
			} else if (highPrice < unitPrice) {
				highPrice = unitPrice;
			}
		}

		averagePrice /= cart.size();

		string = "Low Price = " + decimalFormat.format(lowPrice) + "\nHigh Price = " + decimalFormat.format(highPrice)
				+ "\nAvg Price = " + decimalFormat.format(averagePrice);

		return string;
	}

	private String computeTotal() {
		double totalPrice = 0;
		for (int i = 0; i < cart.size(); i++) {
			totalPrice += cart.get(i).getUnitPrice();
		}

		String total = decimalFormat.format(totalPrice);
		return total;
	}

	public static void main(String[] args) {
		Store store = new Store();
		store.setDefaultCloseOperation(EXIT_ON_CLOSE);
		store.setSize(600, 500);
		store.setTitle("My WebAd Store");
		store.setVisible(true);
	}
}