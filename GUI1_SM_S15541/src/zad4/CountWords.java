/**
 *
 *  @author Szarek Marcin S15541
 *
 */


package zad4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountWords {
	
	String filePath = null;
	
	CountWords (String filePath){
		this.filePath = filePath;
	}
	
	public List<String> getResult() throws IOException{
		try (Scanner scan = new Scanner(new File(filePath))) {
			StringBuilder content = new StringBuilder();
			while (scan.hasNextLine()){
			  content.append(scan.nextLine());		  
			}
			String[] tableOfStr = content.toString().split("[\\s\\p{Punct}]+");
			
			LinkedHashMap<String, Integer> found = new LinkedHashMap<>();
			for (String word: tableOfStr){
				//jeżeli mapa nie zawiera jeszcze słowa-klucza to put key-słowo, 1
				if (!found.containsKey(word)){
				   found.put(word, 1);
				   //jeśli zawiera to put do tego słowa z get słowo z mapy found get value i dodaj 1
				} else{
				   found.put(word, found.get(word) + 1);
				}
			}
			
			List<String> listResult = new ArrayList<String>();
			// entyr nic nie znaczy - może być dupa, nazwa w for each nie ma znaczenia; to mówi tylko jedz po set (key+value) hashmapy found
			//zawierającej Entry - wpisy-pary String, Integer 
			for (Map.Entry<String, Integer> entry: found.entrySet()) {
				//do listy dodaj kolejne pozycje: key spacja value
				listResult.add(entry.getKey() + " " + entry.getValue());
			}
			
			return listResult;		
		} catch (FileNotFoundException e) {
			throw e;
		}
	}
}