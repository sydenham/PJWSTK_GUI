package zad1;

import java.util.ArrayList;

public class Letters extends Thread {
	
	ArrayList<Thread> threads = new ArrayList<Thread>();
	String [] arr;
	
	Letters (String word){
		arr = word.split("(?!^)");
		int i;
		for (i = 0; i < arr.length; i++){
		String letter = arr[i];
			threads.add(new Thread ( () -> {
				while (true){
					try {
					System.out.print(letter);
					  Thread.sleep(1000);
					} catch (InterruptedException e) {
						return;
					}
				}
			}, "Thread " + letter));		
		}
	}
	
	public ArrayList<Thread> getThreads(){
		return threads;
	}
	
}
