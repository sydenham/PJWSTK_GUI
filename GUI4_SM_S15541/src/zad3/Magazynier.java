package zad3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Magazynier extends Thread {
	
	Magazyn magazyn;
	String filePath;
	String [] towar;
	
	Magazynier(Magazyn magazyn, String filePath){
		this.magazyn = magazyn;	
		this.filePath = filePath;
	}
	
	public void run(){		
		try (BufferedReader in = new BufferedReader(new FileReader(filePath))){
			String line = null;
			while ((line = in.readLine()) != null){
				towar = line.toString().split("\\s+");
				magazyn.add(towar);
			}
			if(line == null){
				Thread.sleep(50);
				System.out.println(magazyn.towarWeight);
				magazyn.add(null);
			}
		} catch (IOException e) {
			System.out.println("Błąd pliku");
		} catch (InterruptedException e) {
			System.out.println("Błąd czasu");
		}		
	}
	
}
