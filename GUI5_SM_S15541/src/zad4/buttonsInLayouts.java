package zad4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import zad1.Picture;

public class buttonsInLayouts extends JFrame {

	public buttonsInLayouts() {

	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        makeLayout();
	      }
	    });
	  }

	  protected void makeLayout() throws NullPointerException{
		  
		JButton b1 = new JButton("Przycisk 1");  
		JButton b2 = new JButton("P 2");  
		JButton b3 = new JButton("Większy przycisk numer 3");  
		JButton b4 = new JButton("Przycisk 4");  
		JButton b5 = new JButton("P5");  
		
		
		String input = JOptionPane.showInputDialog("Podaj literę od A do G by otrzymać rządany Layout");  
		
		
		//Dimension d = new Dimension(1000, 500);
		//setPreferredSize(d);
		//getContentPane().setLayout(new BorderLayout());
		
		JPanel p = new JPanel();
		this.setSize(1000, 500);
		//setResizable(false);
		
		this.add(p);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    //pack();
	    setLocationRelativeTo(null);
	    setTitle("Przyciski w żądanym układzie");
	    setVisible(true);	
	    
	    if(input == null){
			dispose();
			JOptionPane.showMessageDialog(null, "Wyszedłeś z aplikacji");
			return;
		}
		
		switch (input){
			case "A": 
			{
				p.setLayout(new BorderLayout());
				p.add(b1, BorderLayout.NORTH);
				p.add(b2, BorderLayout.WEST);
				p.add(b3, BorderLayout.CENTER);
				p.add(b4, BorderLayout.EAST);
				p.add(b5, BorderLayout.SOUTH);
				break;
			}
			case "B":
			{
				p.setLayout(new FlowLayout());
				p.add(b1);
				p.add(b2);
				p.add(b3);
				p.add(b4);
				p.add(b5);
				break;
			}
			case "C":
			{
				p.setLayout(new FlowLayout(FlowLayout.LEFT));
				p.add(b1);
				p.add(b2);
				p.add(b3);
				p.add(b4);
				p.add(b5);
				break;
			}
			case "D":
			{
				p.setLayout(new FlowLayout(FlowLayout.RIGHT));
				p.add(b1);
				p.add(b2);
				p.add(b3);
				p.add(b4);
				p.add(b5);
				break;
			}
			case "E":
			{
				p.setLayout(new GridLayout(1, 1));
				p.add(b1);
				p.add(b2);
				p.add(b3);
				p.add(b4);
				p.add(b5);
				break;
			}
			case "F":
			{
				p.setLayout(new GridLayout(5, 1));
				p.add(b1);
				p.add(b2);
				p.add(b3);
				p.add(b4);
				p.add(b5);
				break;
			}
			case "G":
			{
				p.setLayout(new GridLayout(3, 2));
				p.add(b1);
				p.add(b2);
				p.add(b3);
				p.add(b4);
				p.add(b5);
				break;
			}
			default :
			{
				dispose();
				JOptionPane.showMessageDialog(null, "Błąd wyboru");
			}
		}
		
	  }
	
}
