package zad2;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


class Images extends JPanel {

	List<BufferedImage> images = new LinkedList<BufferedImage>();
	Iterator<BufferedImage> iter ;
	BufferedImage current = null;
	JLabel label = new JLabel();
	
	
	public Images(String path, final int showtime, int fontsize) {
		loadImages(path);
		add(label);
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, fontsize));
		this.setLayout(new GridBagLayout());
		iter = images.iterator();
		new Thread(() -> { 
			while (iter.hasNext()) {
				current = iter.next();
				if (current == null) {
					label.setText("Brak obrazka");
					setPreferredSize(PicShow.DEFAULT_SIZE);
				} else {
					label.setText("");
					Window win = SwingUtilities.getWindowAncestor(this);
					win.setPreferredSize(new Dimension(current.getWidth(), current.getHeight()));
					win.pack();
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					win.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			}
				repaint();
				try {
					Thread.sleep(showtime * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
			current = null;
			label.setText("Koniec prezentacji");
			revalidate();
			repaint();
		}).start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (current != null) {
			g.drawImage(current, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	private void loadImages(String file) {
		File[] files = new File(file).listFiles();
		for (File f: files) {
			if (f.isFile()) {
				try {
					BufferedImage img = ImageIO.read(f);
					images.add(img);
				} catch (IOException e) {
					continue;
				}
			}
		}

	}

}