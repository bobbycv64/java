package us.cv64.graphics.breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * Class that Draws the Extra2 (rect) widget
 */
public class Extra2 extends Target {

	private boolean gotHit = false;

	public Extra2(double xLoc, double yLoc, int sz) {
		super(xLoc, yLoc, sz);
		gotHit = false;
	}

	public boolean isHit() {
		return gotHit;
	}

	@Override
	public void beenHit() {
		gotHit = true;
	}

	@Override
	public void draw(Graphics g) {
		Point2D.Double pt = getLoc();
		int size = getSize();
		g.setColor(Color.WHITE);
		for (int i = 0; i <= 2; i++) {
			g.drawRect((int) pt.x + i, (int) pt.y + i, size - 2 * i, size - 2 * i);
		}
		g.fillRect((int) pt.x + size / 4 + 1, (int) pt.y + size / 4 + 1, size / 2, size / 2);
	}
}
