package zad1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DiagGUI extends JFrame {
	
	 public DiagGUI() {

		    SwingUtilities.invokeLater(new Runnable() {

		      @Override
		      public void run() {
		        drawDiag();
		      }
		    });
		  }

		  protected void drawDiag() {
		    setTitle("Przekątne");
		    add(new Picture());
		    setDefaultCloseOperation(EXIT_ON_CLOSE);
		    //pakowanie do Frame
		    pack();
		    //okno na środek
		    setLocationRelativeTo(null);
		    setVisible(true);
		  }
}
