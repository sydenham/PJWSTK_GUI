package zad2;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import javax.swing.JMenuBar;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenu;

public class Edit extends JFrame {
	
	
	File currentFile;
	private static final HashMap<String,  String []> editLetterAndAccel = new HashMap<String, String []>(); 
	private static final HashMap<String,  Color> optionsColor = new HashMap<String, Color>(); 
	
	static{
		String[] praca = {"P", "Mordor"};
		String[] szkola = {"S", "Uniwersytety"};
		String[] dom = {"D", "Cmentarz"};
		
		editLetterAndAccel.put("Praca", praca);
		editLetterAndAccel.put("Szkoła", szkola);
		editLetterAndAccel.put("Dom", dom);

		optionsColor.put("Blue", Color.BLUE);
		optionsColor.put("Yellow", Color.YELLOW);
		optionsColor.put("Orange", Color.ORANGE);
		optionsColor.put("Red", Color.RED);
		optionsColor.put("White", Color.WHITE);
		optionsColor.put("Black", Color.BLACK);
		optionsColor.put("Green", Color.GREEN);
	}
	
	JTextArea textArea = new JTextArea(300,300);
	JScrollPane sp = new JScrollPane(textArea);
	
	public Edit() {
		
		JMenuBar menuBar = new JMenuBar();
		sp.setColumnHeaderView(menuBar);

		JMenu mnFile = new JMenu("File");
		JMenu mnEdit = new JMenu("Edit");
		JMenu mnOptions = new JMenu("Options");
		JMenu mnAdresy = new JMenu("Adresy");
		JMenu mnForeground = new JMenu("Foreground");
		JMenu mnBackground = new JMenu("Background");
		JMenu mnFontSize = new JMenu("Font size");
		
		JMenuItem open = new JMenuItem("Open"); 
		JMenuItem save = new JMenuItem("Save");
		JMenuItem saveAs = new JMenuItem("Save as ...");
		JMenuItem exit = new JMenuItem("Exit");
		
		setMnemAcc(open, KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
		setMnemAcc(save, KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
		setMnemAcc(saveAs, KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
		setMnemAcc(exit, KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);

		//poniższe robi wygaszone przyciski - trzymam na zaś
		//save.setEnabled(false);
		
		JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL) {
			public void paint(Graphics g) {
				super.paint(g);
			    int w = getBounds().width;
			    Graphics2D g2 = (Graphics2D) g;
				g2.setColor(Color.RED);
			    g2.setStroke(new BasicStroke(3));
			    g2.drawLine(6, 4, w - 8, 4); 
			}
		};
		sep.setPreferredSize(new Dimension(30,10));
		
		fillMenuBar(menuBar, mnFile, mnEdit, mnOptions);
		
		fillMenu(mnFile, open, save, saveAs, sep, exit);
		fillMenu(mnEdit, mnAdresy);
		fillMenu(mnOptions, mnForeground, mnBackground, mnFontSize);
		
		List<JComponent> editItems = createEditItems("Praca", "Szkoła", "Dom");
		fillMenu(mnAdresy, editItems);
		
		String [] colors = {"Blue", "Yellow", "Orange", "Red", "White", "Black", "Green"};
		
		List<JComponent> foreItems = createColorItems("foreground", colors);
		fillMenu(mnForeground, foreItems);
		
		List<JComponent> backItems = createColorItems("background", colors);
		fillMenu(mnBackground, backItems);
		
		List<JComponent> fontSizeItems = createFontSizeItems(8, 10, 12, 14, 16, 18, 20, 22, 24);
		fillMenu(mnFontSize, fontSizeItems);
				
		sp.setPreferredSize(new Dimension(700, 700));
		getContentPane().add(sp);
		setTitle("Prosty edytor - bez tytułu");
				
		open.addActionListener( e -> {
			JFileChooser fc = new JFileChooser();
			if(currentFile == null){	
			fc = new JFileChooser(new File("."));
			}else{
				fc = new JFileChooser(new File(currentFile.getAbsolutePath()));	
			}
			fc.showOpenDialog(null);
			currentFile = fc.getSelectedFile();
			 try
             {
                 FileReader reader = new FileReader(currentFile);
                 BufferedReader br = new BufferedReader(reader);
                 textArea.read( br, null );
                 setTitle("Prosty edytor - " + currentFile.getAbsolutePath().toString());
                 br.close();
               //  save.setEnabled(true);
               //  textArea.requestFocus();
             }
             catch(Exception ex) { JOptionPane.showMessageDialog(null, "Nacisnąłeś cancel"); }
	});
		
		saveAs.addActionListener( e -> {
			JFileChooser fc = new JFileChooser();
			if(currentFile == null){	
			fc = new JFileChooser(new File("."));
			}else{
				fc = new JFileChooser(new File(currentFile.getAbsolutePath()));	
			}
			fc.showSaveDialog(null);
			currentFile = fc.getSelectedFile();
			 try
             {
                 FileWriter writer = new FileWriter( currentFile );
                 BufferedWriter bw = new BufferedWriter(writer);
                 textArea.write(bw);
                 setTitle("Prosty edytor - " + currentFile.getAbsolutePath().toString());
                 bw.close();
                 //save.setEnabled(true);
                 //textArea.setText("");
                 //textArea.requestFocus();
             }
             catch(Exception ex) { JOptionPane.showMessageDialog(null, "Nacisnąłeś cancel"); }
	});
		
		save.addActionListener( e -> {
			if(currentFile == null){
				saveAs.doClick();
			}else{
				 try
	             {
	                 FileWriter writer = new FileWriter(currentFile);
	                 BufferedWriter bw = new BufferedWriter(writer);
	                 textArea.write(bw);
	                 bw.close();
	                 //textArea.setText("");
	                 //textArea.requestFocus();
	             }
	             catch(Exception ex) { JOptionPane.showMessageDialog(null, "Nacisnąłeś cancel"); }
			}	 
	});
		
		exit.addActionListener( e -> {
				  int reply = JOptionPane.showConfirmDialog(null, "Czy chcesz zapisać?", "Wyjście", JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION){
			        	save.doClick();
			        	dispose();
			        }
					dispose();
				});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	private List<JComponent> createFontSizeItems(int ... fontList) {
		List<JComponent> list = new ArrayList<JComponent>();
	    
	    for(Integer i : fontList) {
	    	JMenuItem mi = new JMenuItem(i.toString() + " pts");
	    	mi.setBorder(BorderFactory.createRaisedBevelBorder());
	    	list.add(mi);
	    	
	    	mi.addActionListener( e -> {
	    	Font font = textArea.getFont(); 
	    	textArea.setFont(font.deriveFont((float)i));
	    	}); 	
	    	
	    }
	    return list;
	 }
	
	private List<JComponent> createEditItems(String ... items) {
		List<JComponent> list = new ArrayList<JComponent>();
	    
	    for(String s : items) {
	    	JMenuItem mi = new JMenuItem(s);
	    	String [] keyValue = editLetterAndAccel.get(s);
	    	Character c = keyValue[0].charAt(0);
	    	KeyEvent.getExtendedKeyCodeForChar(c);
	    	setMnemAcc(mi, KeyEvent.getExtendedKeyCodeForChar(c) , ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK);
	    	mi.setBorder(BorderFactory.createRaisedBevelBorder());
	    	list.add(mi);
	    	
	    	mi.addActionListener( e -> {
	    	textArea.insert(keyValue[1], textArea.getCaretPosition());
	    	}); 	
	    	
	    }
	    return list;
	 }
	
	private List<JComponent> createColorItems(String ground, String ... items) {
		List<JComponent> list = new ArrayList<JComponent>();
	    
	    for(String s : items) {
	    	JMenuItem mi = new JMenuItem(s);
	    	Color color = optionsColor.get(s);
	    	mi.setIcon(new MakeIcon(color));
			mi.setHorizontalTextPosition(SwingConstants.RIGHT);
			mi.setVerticalTextPosition(SwingConstants.CENTER);
	    	mi.setBorder(BorderFactory.createRaisedBevelBorder());
	    	list.add(mi);
	    	if (ground.equals("background")) {
	    		mi.addActionListener( e -> {textArea.setBackground(color);});
	    	} else if (ground.equals("foreground")) {
	    		mi.addActionListener( e -> {textArea.setForeground(color);});
	    	} else { 
	    		JOptionPane.showMessageDialog(null, "Błąd wyboru: czy dotyczy tła czy kolorów");	
	    		}
	    }
	    return list;
	 }
	
	private void fillMenuBar(JComponent menuBar, JComponent ... items) {
	    for(JComponent menu : items) {
	      menuBar.add(menu);
	    }
	}
	
	private void fillMenu(JComponent menu, List<JComponent> items) {
		for(JComponent item : items) {
			addFormatedItem(menu, item);
		}
	}
	
	private void fillMenu(JComponent menu, JComponent ... items) {
		for(JComponent item : items) {
			addFormatedItem(menu, item);
		}
}
	private void addFormatedItem(JComponent menu, JComponent item) {
		item.setBorder(BorderFactory.createRaisedBevelBorder());
		menu.add(item);
	}
	
	private void setMnemAcc(JMenuItem item, int kE, int kE2){
		item.setMnemonic(kE);
		KeyStroke keyStrokeToSave = KeyStroke.getKeyStroke(kE, kE2);
		item.setAccelerator(keyStrokeToSave);
	}

}
