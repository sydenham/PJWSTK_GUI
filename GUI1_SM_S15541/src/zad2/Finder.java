/**
 *
 *  @author Szarek Marcin S15541
 *
 */

package zad2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {

	String filePath = null;
	
	Finder (String filePath){
		this.filePath = filePath;
	}
	
	public String readFile() throws IOException{
		StringBuilder content = new StringBuilder();		
		try (BufferedReader in = new BufferedReader(new FileReader(filePath))){
			String line = null;
			while ((line = in.readLine()) != null){
				content.append(line);
				content.append(System.lineSeparator());
			}
			return content.toString();
		} 
	};
	
	public int getIfCount()throws IOException, FileNotFoundException{
		int i = 0;
		String text = readFile();
		text= text.replaceAll("//.*", "").replaceAll("/\\*(.|[\\n])\\*/", "").replaceAll("\".*\"", "").replaceAll("\'.*\'", "");
		Pattern p = Pattern.compile("if\\s*\\(.+?\\)");
		Matcher m = p.matcher(text);
		while(m.find())
			i++;
		return i;
	}

	public int getStringCount(String str)throws IOException, FileNotFoundException{
		int i = 0;
		String text = readFile();
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(text);
		while(m.find())
			i++;
		return i;
	}
	
}    
