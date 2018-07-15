/**
 *
 *  @author Szarek Marcin S15541
 *
 */

package zad4;

import java.util.concurrent.LinkedBlockingQueue;

public class Author implements Runnable {
	String [] words;
	LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
	public static String POISON_PILL = "POISON_PILL";
	
	
	Author(String [] words){
		this.words = words;
	}
	
	public LinkedBlockingQueue<String> getText(){
		return queue;
	}
	
	public void run() {
		for(int i = 0; i < words.length; i++){
		     try {
			     queue.put(words[i]);
			     Thread.sleep(1000);
			     	if (i + 1 == words.length){
			     		queue.put(POISON_PILL);	 
			     	}
		     } catch (InterruptedException ex) 
		     	{ System.out.println("Błąd autora");
		    	}
		}
	 }
}  
