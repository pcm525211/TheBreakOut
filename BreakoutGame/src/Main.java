import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("The Breakout");
		
		JPanel panel = new JPanel();
		frame.getContentPane();
		
		JLabel stage1 = new JLabel("stage1");
		Dimension size1 = stage1.getPreferredSize();
		stage1.setForeground(Color.white);
		stage1.setBounds(400, 200, size1.width, size1.height);
		stage1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				System.out.println("Click Stage1");
				
				Gameplay gp = new Gameplay(1);
				
				frame.getContentPane().removeAll();
				frame.getContentPane().add(gp);
				frame.setSize(800, 700);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		JLabel stage2 = new JLabel("stage2");
		Dimension size2 = stage2.getPreferredSize();
		stage2.setForeground(Color.white);
		stage2.setBounds(400, 400, size2.width, size2.height);
		stage2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				System.out.println("Click Stage2");
				Gameplay gp = new Gameplay(2);
				
				frame.getContentPane().removeAll();
				frame.getContentPane().add(gp);
				frame.setSize(800, 700);
				frame.revalidate();
				frame.repaint();
			}
		});
		
		panel.setBackground(Color.gray);
		panel.setLayout(null);
		panel.add(stage1);
		panel.add(stage2);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(800, 700);
		frame.setVisible(true);
	      
		
	}

}
