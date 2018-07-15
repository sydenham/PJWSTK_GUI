package zad2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class MakeIcon implements Icon {
	
	
	  private Color color;
	  private int w = 16;

	  MakeIcon(Color c) {
	    color = c;
	  }

	  public void paintIcon(Component c, Graphics g, int x, int y) {
	    g.setColor(color);
	    w = c.getHeight() / 2;
	    int p = w / 6, d = w ;
	    g.fillOval(x + p, y + p, d, d);
	  }
	  
	  public int getIconWidth() {
		    return w;
		  }

	  public int getIconHeight() {
		    return w;
		  }

}
