package zad3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Sort {

	
	String filePath = null;
	
	Sort (String filePath){
		this.filePath = filePath;
	}
	
	
	public void readFile(){
		Scanner scan = null;
	try {
		scan = new Scanner(new File(filePath));
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while (scan.hasNext())
		list.add(Integer.parseInt(scan.next()));
		
		int maxValue = Collections.max(list);
		
		for (Integer a : list) System.out.print(a + " ");
		System.out.println();
		System.out.println(maxValue);
		
		Integer[] array = list.toArray(new Integer[0]);
		
		for (int i = 0; i < array.length; i++){
			if (array[i] == maxValue)
				System.out.print(i + " ");
		}
		
	} catch (IOException | NumberFormatException e) {
		System.out.println("***");
		//finally - na sam koniec zamknij połączenie
		// finally - dzięki niemu zawsze wykona się po try, a robi cleanup - porządkuje nawet po błędzie, np. zamyka połączenie
	}finally {
		if(scan != null)
			scan.close();
	}
      
	}  
}
