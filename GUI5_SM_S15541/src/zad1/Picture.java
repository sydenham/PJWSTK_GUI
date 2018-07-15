package zad1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Picture extends JComponent {
	
		  public Picture() {
			 Dimension d = new Dimension(100, 100);
			 setPreferredSize(d);
		  }

		  public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int w = getWidth();
			int h = getHeight();
			g.setColor(Color.blue);
			int hor = 10, vert = 10;
			g.drawLine(0, 0, w-1, h-1);
			g.drawLine(0, h-1, w-1, 0);
		  }	
}
