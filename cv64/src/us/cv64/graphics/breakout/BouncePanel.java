package us.cv64.graphics.breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class BouncePanel extends JPanel implements ActionListener {

	private static final int MAX_COLUMNS = 7;
	private static final int PARTICLE_SIZE = 17;
	private static final int PARTICLE_SPEED = 6;
	private static final int PARTICLE_DELAY = 12;

	private static final double BLOCK_DOUBLE_CHANCE = 0.3;
	private static final double BLOCK_CHANCE = 0.55;
	private static final int BLOCK_PADDING = 5;

	private static final double ANGLE_NOISE = Math.PI / 10;
	private static final double ANGLE_NOISE_CHANCE = 0.2;
	private static final double ANGLE_TOL = Math.PI / 12;

	private Timer timer;
	private Point mouseCoords;
	private ArrayList<Particle> particles;
	private int particleIndex;
	private int particleTick;
	private int activeParticles;
	private int particleCount;
	private int blockSize;
	private int blocksPerRow;
	private int blockLevel;
	private int newExtra;
	private boolean getInput;
	private boolean canShoot;
	private boolean firstBack;
	private int addParticles;
	private double origin;
	private int bottom;
	private int top;
	private double startingAngle;
	private ArrayList<Target> targets;
	private int previousLevel = 0;
	private boolean squareWidget = false;
	private int randomNumber = 0;

	/**
	 * BouncePanel Constructor
	 * 
	 * @param xDim
	 *            width of the game
	 * @param yDim
	 *            height of the game
	 * @param numPerRow
	 *            number of columns
	 */
	public BouncePanel(int xDim, int yDim, int numPerRow) {
		setBackground(Color.BLACK);
		addMouseListener(new MAdapter());
		addMouseMotionListener(new MAdapter());
		setFocusable(true);
		setDoubleBuffered(true);

		timer = new Timer(1, this);
		timer.start();

		getInput = true;
		canShoot = true;
		firstBack = true;

		mouseCoords = new Point();

		particles = new ArrayList<Particle>();

		particleIndex = 0;
		particleTick = 0;
		particleCount = 1;
		addParticles = 0;

		blocksPerRow = numPerRow;
		blockSize = (int) ((xDim - 2 * BLOCK_PADDING) / blocksPerRow);
		blockLevel = 1;
		top = yDim / 15;
		bottom = 8 * yDim / 9;
		origin = xDim / 2;
		for (int i = 0; i < particleCount; i++) {
			particles.add(new Particle(origin, bottom, PARTICLE_SPEED, 0, PARTICLE_SIZE));
		}

		targets = new ArrayList<Target>();
		newExtra = (int) (Math.random() * blocksPerRow);
		for (int i = 0; i < blocksPerRow; i++) {
			addNewTarget(i, blockLevel, newExtra);
		}
	}

	/**
	 * paintComponent method draws graphics on a Canvas / Panel
	 */
	public void paintComponent(Graphics g) { // draw graphics in the panel
		super.paintComponent(g); // call superclass to make panel display correctly
		g.drawLine(0, bottom, getWidth(), bottom);
		g.setColor(Color.WHITE);
		g.drawString("" + particleCount, 100, bottom + 20);
		drawTargets(g);
		if (getInput) {
			if (canShoot) {
				g.setColor(Color.WHITE);
			} else {
				g.setColor(Color.RED);
			}
			g.fillOval((int) origin, bottom, PARTICLE_SIZE, PARTICLE_SIZE);
			g.drawLine((int) origin + PARTICLE_SIZE / 2, bottom + PARTICLE_SIZE / 2, mouseCoords.x, mouseCoords.y);
		} else {
			g.setColor(Color.CYAN);
			drawParticles(g);
		}
	}

	public void drawParticles(Graphics g) {
		for (Particle p : particles) {
			p.draw(g);
		}
	}

	public void drawTargets(Graphics g) {
		for (Target t : targets) {
			t.draw(g);
		}
	}

	/**
	 * returns if a block was hit
	 * 
	 * @param p
	 *            ball
	 * @param t
	 *            target = block
	 * @return boolean if a block was hit
	 */
	public boolean blockHit(Particle p, Target t) {
		if (t.getBounds().intersects(new Rectangle((int) (p.getLoc().x + p.getVel().x),
				(int) (p.getLoc().y + p.getVel().y), PARTICLE_SIZE, PARTICLE_SIZE))) {
			if (Math.abs(p.getLoc().x + PARTICLE_SIZE / 2 - t.getLoc().x - t.getSize() / 2) < Math
					.abs(p.getLoc().y + PARTICLE_SIZE / 2 - t.getLoc().y - t.getSize() / 2)) {
				p.setAngle(-p.getAngle());
				p.bounce((int) (Math.random() + ANGLE_NOISE_CHANCE) * ANGLE_NOISE);
			} else {
				p.setAngle(Math.PI - p.getAngle());
				p.bounce((int) (Math.random() + ANGLE_NOISE_CHANCE) * ANGLE_NOISE);
			}
			t.beenHit();
		}
		Block b = (Block) t;
		return ((Block) t).getNumber() == 0;
	}

	/**
	 * returns if an extra was hit
	 * 
	 * @param p
	 *            ball
	 * @param t
	 *            target = extra
	 * @return boolean if an extra was hit
	 */
	public boolean extraHit(Particle p, Target t) {
		if (t.getBounds().intersects(new Rectangle((int) (p.getLoc().x + p.getVel().x),
				(int) (p.getLoc().y + p.getVel().y), PARTICLE_SIZE, PARTICLE_SIZE))) {
			if (t instanceof Extra) {
				addParticles++;
				return true;
			}
		}
		return false;
	}

	/**
	 * returns if an extra2 was hit
	 * 
	 * @param p
	 *            ball
	 * @param t
	 *            target = extra2
	 * @return boolean if an extra2 was hit
	 */
	public boolean extraHit2(Particle p, Target t) {
		if (t.getBounds().intersects(new Rectangle((int) (p.getLoc().x + p.getVel().x),
				(int) (p.getLoc().y + p.getVel().y), PARTICLE_SIZE, PARTICLE_SIZE))) {
			if (t instanceof Extra2) {
				addParticles++;
				return true;
			}
		}
		return false;
	}

	public void updateTargets() {
		Point2D.Double trash = new Point2D.Double(1000, 1000);
		for (int i = 0; i < targets.size(); i++) {
			if (targets.get(i).getLoc().equals(trash)) {
				targets.remove(i);
			}
		}
	}

	/**
	 * removes or adds particles
	 * 
	 * @return
	 */
	public int updateParticles() {
		activeParticles = 0;
		for (Particle p : particles) {
			if (p.isActive()) {
				activeParticles++;
				for (int i = 0; i < targets.size(); i++) {

					/*
					 * if extra = remove or decrement the block or block value
					 */
					if (targets.get(i) instanceof Extra) {
						if (extraHit(p, targets.get(i))) {
							targets.remove(i);

							System.out.println("Extra Removed: " + i);
						}

						/*
						 * if extra2 = remove several blocks
						 */
					} else if (targets.get(i) instanceof Extra2) {
						if (extraHit2(p, targets.get(i))) {

							try {
								for (int j = 0; j < MAX_COLUMNS; j++) {
									targets.remove(j);
									System.out.println("Extra 2 Removed: " + i);
								}
							} catch (Exception exception) {
								System.err.println(exception.getMessage());
							}
						}

						/*
						 * if block = remove or decrement the block or block value
						 */
					} else {
						if (blockHit(p, targets.get(i))) {
							targets.remove(i);
							System.out.println("Block Removed: " + i);
						}
					}
				}
				if ((p.getLoc().x + PARTICLE_SIZE + p.getVel().x) > getWidth() || (p.getLoc().x + p.getVel().x < 0)) {
					p.setAngle(Math.PI - p.getAngle());
					// p.bounce((int)(Math.random() + ANGLE_NOISE_CHANCE) * ANGLE_NOISE);
				}
				if ((p.getLoc().y + p.getVel().y < 0)) {
					p.setAngle(-p.getAngle());
					// p.bounce((int)(Math.random() + ANGLE_NOISE_CHANCE) * ANGLE_NOISE);
				}
				if (p.getLoc().y + p.getVel().y > bottom) {
					if (firstBack) {
						origin = p.getLoc().x + p.getVel().x * (p.getLoc().y - bottom) / p.getVel().y;
						firstBack = false;
					}
					p.setLoc(origin, bottom);
					p.deactivate();
				} else {
					p.update();
				}
			}
		}
		return activeParticles;
	}

	/**
	 * add a new target = extra (circle), extra2 (rectangle) or block
	 * 
	 * @param index
	 * @param level
	 * @param getExtra
	 */
	public void addNewTarget(int index, int level, int getExtra) {

		if (level != previousLevel) {
			randomNumber = getRandomNumberInRange(getExtra);
			previousLevel = level;
		}

		// add circle widget
		if (index == getExtra) {
			targets.add(new Extra(BLOCK_PADDING - 1 + index * blockSize, top, blockSize));

			squareWidget = true;

			// add block
		} else {
			// add square widget
			if (squareWidget) {
				targets.add(new Extra2(BLOCK_PADDING - 1 + randomNumber * blockSize, top, blockSize));
				squareWidget = false;
			} else if (Math.random() < BLOCK_CHANCE) {
				targets.add(new Block(BLOCK_PADDING - 1 + index * blockSize, top, blockSize,
						level + level * (int) (Math.random() + BLOCK_DOUBLE_CHANCE), 2 * level));
			}
		}
	}

	/**
	 * after a round is played (a level) create a new level
	 */
	public void prepareNextRound() {
		for (Target t : targets) {
			t.setLoc(t.getLoc().x, t.getLoc().y + blockSize);
		}
		for (int i = 0; i < targets.size(); i++) {
			if (targets.get(i).getLoc().y > bottom) {
				System.out.println("You lose");
				System.exit(0);
				targets.remove(i);
			}
		}
		blockLevel++;
		newExtra = (int) (Math.random() * getWidth() / blockSize);
		for (int i = 0; i < getWidth() / blockSize; i++) {
			addNewTarget(i, blockLevel, newExtra);
		}
		particleIndex = 0;
		particleTick = 0;
		for (int i = 0; i < addParticles; i++) {
			particleCount++;
			particles.add(new Particle(origin, bottom, PARTICLE_SPEED, 0, PARTICLE_SIZE));
		}
		addParticles = 0;
	}

	@Override
	/**
	 * when a window widget has been selected
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (!getInput) {
			if (particleIndex < particles.size()) {
				if (particleTick == 0) {
					particles.get(particleIndex).activate();
					particleIndex++;
				}
			}
			particleTick = (particleTick + 1) % PARTICLE_DELAY;
			getInput = (0 == updateParticles());
			updateTargets();
			if (getInput)
				prepareNextRound();
		}
		repaint();
	}

	public boolean calcVel(double start, Point end) {
		double angle = Math.atan2(end.y - bottom, end.x - origin);
		if ((angle > ANGLE_TOL - Math.PI) && (angle < -ANGLE_TOL)) {
			startingAngle = angle;
			canShoot = true;
			return true;
		}
		canShoot = false;
		return false;
	}

	private class MAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			mouseCoords.x = e.getX();
			mouseCoords.y = e.getY();
			if (getInput) {
				if (calcVel(origin, mouseCoords)) {
					getInput = false;
					firstBack = true;
					for (Particle p : particles) {
						p.setAngle(startingAngle);
					}
				}
			}
		}

		/**
		 * called when the mouse has been moved and get the X / Y coordinates
		 */
		@Override
		public void mouseMoved(MouseEvent e) {
			mouseCoords.x = e.getX();
			mouseCoords.y = e.getY();
			calcVel(origin, mouseCoords);
		}
	}

	/**
	 * generate random number between a minimum and maximum value and not the same
	 * value as the extra widget
	 * 
	 * @param extra
	 * @return
	 */
	private static int getRandomNumberInRange(int extra) {

		Random random = new Random();
		int minimum = 0;
		int maximum = MAX_COLUMNS;
		int randomNumber = 0;

		do {
			randomNumber = random.nextInt((maximum - minimum) + 1) + minimum;

		} while (randomNumber == extra);

		return randomNumber;
	}
}
