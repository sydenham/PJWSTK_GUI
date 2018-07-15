package zad2;

import java.awt.Dimension;
import javax.swing.JFrame;

import javax.swing.SwingUtilities;

public class PicShow extends JFrame {

	static final Dimension DEFAULT_SIZE = new Dimension(500, 500);
	
	String[] args;

	public PicShow(String[] args) {
		this.args = args;

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Images images = new Images(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));
				add(images);
				Dimension d = DEFAULT_SIZE;
				setPreferredSize(d);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				pack();
				setLocationRelativeTo(null);
				setVisible(true);
			}
		});
	}
}
