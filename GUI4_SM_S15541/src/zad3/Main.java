/**
 *
 *  @author Szarek Marcin S15541
 *
 */

package zad3;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
	  
	  	Magazyn magazyn = new Magazyn();	    
	    Thread a = new Magazynier(magazyn, "../Towary.txt");
	    Thread b = new Waga(magazyn);
	    a.start();
	    b.start();
	    
  }
}
