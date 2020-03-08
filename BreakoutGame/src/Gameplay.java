import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener, MouseMotionListener {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 700;
	public static final int BALL_RADIUS = 20;
	private boolean play = false;
	private boolean gameOver = false;
	private int score = 0;

	private int totalBricks = 10;

	private Timer timer;
	private int delay =(int) 20;

	private int playerX = 400;

	private int ballposX = 430;
	private int ballposY = 630;
	private int ballXdir = -5;
	private int ballYdir = -5;

	private MapGenerator map;

	public Gameplay() {
		map = new MapGenerator(20, 20);
		map.setOffset(0, 0);
		int a = 10;
		int b = 10;
		int r = 5;
//		for(int i = 0; i < map.map.length; i++) {
//			for(int j = 0; j < map.map[i].length; j++) {
//				if((i - a)*(i - a) + (j - b)*(j - b) >= r * r) {
//					map.setBrickValue(1, i, j);
//				}
//			}
//			
//		}
		
		MapBuilder mb = new MapBuilder(map, new InvertedShape(new ShapeUnion(new Cerc(5, 10, 7), new Cerc(15, 10, 7))));
		mb.deseneaza();
		
		addKeyListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setSize(WIDTH, HEIGHT);
		timer = new Timer(delay, this);
		timer.start();
	}

	@Override
	public Dimension getPreferredSize() {
		return this.getSize();
	}

	public void paint(Graphics g) {
		// background
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 800, 700);

		// drawing map
		map.draw((Graphics2D) g);
		
		//score
		if(gameOver) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("serif", Font.BOLD, 25 ));
			g.drawString("Game Over", 350, 200);
		}else {
			g.setColor(Color.BLACK);
			g.setFont(new Font("serif", Font.BOLD, 25 ));
			g.drawString("Score: "+ score, 10, 690);
			
		}
		// the paddle
		g.setColor(Color.GREEN);
		g.fillRect(playerX, 650, 100, 8);

		// the ball
		g.setColor(Color.YELLOW);
		g.fillOval(ballposX, ballposY, BALL_RADIUS, BALL_RADIUS);

		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {

		if (play) {
			Rectangle ballRect = new Rectangle(ballposX, ballposY, BALL_RADIUS, BALL_RADIUS);

			if (ballRect.intersects(new Rectangle(playerX, 650, 100, 8))) {
				ballYdir = -ballYdir;
				ballXdir = +ballXdir;
			}
	
			doCollisions(ballRect);

			if (ballposX < 0) {
				ballXdir = -ballXdir;
			}
			if (ballposX > WIDTH - BALL_RADIUS) {
				ballXdir = -ballXdir;
			}

			if (ballposY < 0) {
				ballYdir = -ballYdir;
			}
			if (ballposY > HEIGHT) {
				play = false;
				gameOver = true;
			}
			ballposX += ballXdir;
			ballposY += ballYdir;

		}
		repaint();
	}

	private void doCollisions(Rectangle ballRect) {
		for (int i = 0; i < map.map.length; i++) {
			for (int j = 0; j < map.map[0].length; j++) {
				if (map.map[i][j] > 0) {
					Rectangle brickRect = map.getCollision(ballRect, i, j);
					if (brickRect != null) {
						map.setBrickValue(0, i, j);
						totalBricks--;
						score += 5;

						if (ballposX <= brickRect.x || ballposX >= brickRect.x + brickRect.width) {
							ballXdir = -ballXdir;
						} else {
							ballYdir = -ballYdir;
						}
						return;
					}
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println(playerX + " "+ WIDTH);
			if (playerX >= WIDTH - 100) {
				playerX = WIDTH - 100;
			} else {
				moveRight();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (playerX <= 0) {
				playerX = 0;
			} else {
				moveLeft();
			}
		}
	}

	public void moveRight() {
		play = true;
		playerX += 20;
	}

	public void moveLeft() {
		play = true;
		playerX -= 20;
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		play = true;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(play)
			playerX = e.getX() - 50;
	}
}
