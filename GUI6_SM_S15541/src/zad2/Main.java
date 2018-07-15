/**
 *
 *  @author Szarek Marcin S15541
 *
 */

package zad2;

import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
	  
	  SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        new Edit();
	      }
	    });
  }
}
