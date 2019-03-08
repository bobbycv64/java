package us.cv64.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawToolPanel extends JPanel {
	
	private String price = "";

	public DrawToolPanel(String price) {
		setPreferredSize(new Dimension(400, 400));
		this.price = price;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// background color
		g.setColor(new Color(253, 223, 223, 255));
		g.fillRect(0, 0, 320, 320);
		// nail polish color
		g.setColor(new Color(255, 153, 204, 255));
		g.fillRect(222, 160, 86, 99);

		g.setColor(new Color(0, 0, 0, 255));
		g.fillRect(253, 68, 25, 93);
		// top label oval
		g.setColor(new Color(255, 204, 204, 255));
		g.fillOval(222, 185, 86, 49);
		// bottom label oval
		g.setColor(new Color(255, 204, 204, 255));
		g.fillOval(222, 198, 86, 43);

		g.setColor(new Color(255, 255, 255, 255));
		g.fillOval(222, 191, 86, 43);

		g.setColor(new Color(0, 0, 0, 255));

		g.setFont(new Font("Georgia", 1, 9));
		g.drawString("Poop Deck Pink", 228, 272);

		g.setFont(new Font("Treasure Map Deadhand", 0, 18));
		g.drawString("Walk The Plank Nail Polish Co.", 56, 296);

		g.setFont(new Font("Trattatello", 1, 32));
		g.drawString("Pirate Nail Polish", 49, 31);

		g.setFont(new Font("Monospaced", 1, 11));
		g.drawString("www.polishforpirates.com", 68, 315);

		g.setColor(new Color(255, 255, 255, 255));
		g.drawRoundRect(12, 62, 142, 86, 15, 19);

		g.setColor(new Color(0, 0, 0, 255));

		g.setFont(new Font("Treasure Map Deadhand", 1, 28));
		g.drawString("Fictitious ", 19, 86);
		g.drawString("Product No.", 19, 111);

		g.setFont(new Font("Treasure Map Deadhand", 1, 24));
		g.drawString("1245", 19, 136);

		g.setColor(new Color(255, 255, 255, 255));
		g.drawRoundRect(12, 160, 142, 68, 10, 16);

		g.setColor(new Color(0, 0, 0, 255));

		g.setFont(new Font("Treasure Map Deadhand", 1, 20));
		g.drawString("Shiver me timbers!", 19, 185);

		g.setFont(new Font("Treasure Map Deadhand", 1, 22));
		g.drawString("ONLY", 19, 210);

		g.setFont(new Font("Trattatello", 1, 26));
		g.drawString(price, 80, 210);
		// bottle stripes
		g.setColor(new Color(255, 153, 153, 255));
		g.fillRect(253, 74, 25, 12);
		// bottle stripes
		g.setColor(new Color(255, 204, 204, 255));
		g.fillRect(253, 93, 25, 6);
		// bottle stripes
		g.setColor(new Color(255, 204, 204, 255));
		g.fillRect(253, 105, 25, 6);

		g.setColor(new Color(0, 0, 0, 255));

		g.setFont(new Font("Treasure Map Deadhand", 2, 16));
		g.drawString("Pirate Polish", 228, 216);
	}
}
