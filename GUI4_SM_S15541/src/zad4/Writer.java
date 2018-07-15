/**
 *
 *  @author Szarek Marcin S15541
 *
 */

package zad4;


public class Writer implements Runnable {
	
	Author author;
	
	Writer(Author author){
		this.author = author;
	}
	
	public void run(){
		while(true){
			try{
				String text = author.getText().take();
				if (text == "POISON_PILL"){
					return;
				}
				System.out.println("-> " + text);
			}catch(InterruptedException ex) 
		     	{ System.out.println("Błąd Writera");
		    	}
		}
	}
}
