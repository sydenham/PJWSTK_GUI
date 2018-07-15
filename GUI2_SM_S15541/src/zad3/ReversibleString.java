package zad3;

public class ReversibleString implements Reversible<String>{
	
	String word;
	

	public ReversibleString (String word){
		this.word = word;
	}
	
	public String reverse(){
		  StringBuilder sb = new StringBuilder();
		  sb.append(word);
		  return word = sb.reverse().toString();
	}
	
	public String addText(){
		  StringBuilder sb = new StringBuilder();
		  sb.append("Tekst " + word);
		  return word = sb.toString();
	}
	
	
	public String toString(){
		return word;
	}
	
}
