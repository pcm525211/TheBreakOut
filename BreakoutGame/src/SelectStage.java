import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SelectStage extends JPanel{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 700;
	
	public void paint(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 800, 700);
		g.setColor(Color.WHITE);
		g.drawString("stage1", 400, 200);
		g.drawString("stage2", 400, 400);
	}
}
