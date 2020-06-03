import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame obj = new JFrame();
		obj.setPreferredSize(new Dimension(800,600));
		obj.setLayout(null);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SelectStage selectstage = new SelectStage();
		obj.setContentPane(selectstage);
		obj.setTitle("The Breakout");
		obj.setResizable(true);
		obj.pack();
		obj.setVisible(true);
	}

}
