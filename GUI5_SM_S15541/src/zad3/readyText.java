package zad3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class readyText extends JFrame {
	
			String tFont;
			String tColour;
			Integer tSize;
			String bColour;
			boolean isBold;
			boolean isItalic;
	
	 public readyText(String tFont, String tColour,	String tSize, String bColour, boolean isBold, boolean isItalic) {
		 	this.tFont = tFont;
		 	this.tColour = tColour;
		 	if(tSize == null){
				this.tSize = 20;
		 	}else{
		 		this.tSize = Integer.parseInt(tSize);
		 	}
		 	this.bColour = bColour;
		 	this.isBold = isBold;
		 	this.isItalic = isItalic;
		 	

		    SwingUtilities.invokeLater(new Runnable() {

		      @Override
		      public void run() {
		        makeText();
		      }
		    });
		  }

		  protected void makeText() {
			
			JTextArea txt = new JTextArea(80, 80);
			JScrollPane sp = new JScrollPane(txt);
			sp.setPreferredSize(new Dimension(700, 700));
			
			Font font;
			setTitle("Pole tekstowe");
			
			if(isBold && isItalic){
				font = new Font(tFont, Font.ITALIC | Font.BOLD, tSize);	
			}else if(!isBold && isItalic){
				font = new Font(tFont, Font.ITALIC, tSize);	
			}else if(isBold && !isItalic){
				font = new Font(tFont, Font.BOLD, tSize);	
			}else {
				font = new Font(tFont, Font.PLAIN , tSize);
			}	
			
			if(bColour == "żółty"){
				txt.setBackground(Color.YELLOW);
			}else if(bColour == "zielony"){
				txt.setBackground(Color.GREEN);
			}else if(bColour == "niebieski"){
				txt.setBackground(Color.BLUE);
			}else {
				txt.setBackground(Color.WHITE);
			}
			
			if(tColour == "czerwony"){
				txt.setForeground(Color.RED);
			}else if(tColour == "szary"){
				txt.setForeground(Color.GRAY);
			}else {
				txt.setForeground(Color.BLACK);
			}
			
			txt.setFont(font);
			this.add(sp);
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
		    pack();
		    setLocationRelativeTo(null);
		    setVisible(true);
		  }
}