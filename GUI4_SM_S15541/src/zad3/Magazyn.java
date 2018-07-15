package zad3;

import java.util.LinkedList;

public class Magazyn {
	
	public boolean towarAdded = false;
	LinkedList<Towar> magazyn = new LinkedList<Towar>();
	String [] towar;
	int towarOnStock;
	int towarOnScale;
	float towarWeight;
	boolean wagaStop = false;
	
	synchronized public void add(String [] towar){
     	while(towarAdded){
	     	try {
	     		wait();
	       } catch (InterruptedException exc) {
    	   System.out.println("Oczekiwanie przerwane"); 
    	   }
     	}
     	if(towar == null){
     		wagaStop = true;
     	}else{	
			magazyn.add(new Towar(towar[0], towar[1]));
			towarOnStock++;
			if(towarOnStock %200 == 0) {
				System.out.println("utworzono " +  towarOnStock + " obiektów");
			}
     	}
		towarAdded = true; 
		notifyAll();
	};
		
	
		
	synchronized public void getWeight(){
		while(!towarAdded){
			try{
				wait();
			}catch (InterruptedException exc) {
	    	   System.out.println("Oczekiwanie przerwane"); 
	    	}
		}
		if (wagaStop == true)
			return;
		towarOnScale++;
		towarWeight = towarWeight + magazyn.getLast().wagaTowaru;
		if(towarOnScale %100 == 0) {
			System.out.println("policzono wage " +  towarOnScale + " towarów");
		}		
		towarAdded = false;
		notifyAll();
	}
}
