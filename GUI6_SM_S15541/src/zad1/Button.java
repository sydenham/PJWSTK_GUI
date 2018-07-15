package zad1;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Button extends JFrame {
	
	 Color[] color = { Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN };
	 JButton b = new JButton("Przycisk");
	 int currColor=0;
	 
	 public Button() {

		    SwingUtilities.invokeLater(new Runnable() {

		      @Override
		      public void run() {
		        makeButt();
		      }
		    });
		  }
	/* public void actionPerformed(ActionEvent e) {
		    if (currColor > color.length){
		    	currColor=0 ;
		    }
		    b.setBackground(color[currColor]);
		    currColor++;
		  }
	 */
	 private void makeButt(){
			setTitle("Przycisk");
			getContentPane().setLayout(new FlowLayout());
			// b.addActionListener(this);
			
			b.addActionListener( e -> {
				if (currColor == color.length){
			    	currColor = 0;
			    }
			    b.setBackground(color[currColor]);
			    currColor++;
		});
			
			add(b);	 
	 		setDefaultCloseOperation(EXIT_ON_CLOSE);
			pack();
			setLocationRelativeTo(null);
			setVisible(true);
	 }
}
