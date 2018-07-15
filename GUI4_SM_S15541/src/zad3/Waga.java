package zad3;

public class Waga extends Thread {

	Magazyn magazyn;
	
	Waga (Magazyn magazyn){
		this.magazyn = magazyn;
	}
	
	public void run(){
		while(!magazyn.wagaStop){
		magazyn.getWeight();
		}
	}
		
}
