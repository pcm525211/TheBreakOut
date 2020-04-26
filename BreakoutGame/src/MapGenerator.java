import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MapGenerator {
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	
	private int offsetX;
	private int offsetY;

	public MapGenerator(int row, int col) {
		map = new int[row][col];
		brickWidth = Gameplay.WIDTH / col;
		brickHeight = Gameplay.HEIGHT/ 2 / row;
	}

	public void setOffset(int offsetX, int offsetY) {
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}
	
	public void draw(Graphics2D g) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] > 0) {
					g.setColor(Color.white);
					g.fillRect(j * brickWidth + offsetX, i * brickHeight + offsetY, brickWidth, brickHeight);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j * brickWidth + offsetX, i * brickHeight + offsetY, brickWidth, brickHeight);
				}
			}
		}
	}
	public void setBrickValue (int value, int row, int col) {
		map[row][col] = value;
	}

	public Rectangle getCollision(Rectangle ballRect, int i, int j) {
		int brickX = j * brickWidth + offsetX;
		int brickY = i * brickHeight + offsetY;

		Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
		if(ballRect.intersects(brickRect)) {
			return brickRect;
		}else {
			return null;
		}
	}
}
