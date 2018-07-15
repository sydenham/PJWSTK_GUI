/**
 *
 *  @author Szarek Marcin S15541
 *
 */

package zad4;


public abstract class Spiewak {
	
	static int next;
	int singerNumber;
	String name;
	
	Spiewak(String name){
		this.name = name;
		next++;
		singerNumber = next;
	}
	
	abstract String spiewaj();
	
	public String toString(){
		return "(" + singerNumber + ") " + name + ": "  + spiewaj(); 
	}
	
	
	
	static Spiewak najglosniej(Spiewak sp []){
		Spiewak najglosniejszy = null; 
		int max = -1;
		for (Spiewak s: sp) {
			int current = 0;
			for (char c: s.spiewaj().toCharArray()) {
				if (Character.isUpperCase(c)) current++;
			}	
			if (current > max) {
				najglosniejszy = s;
				max = current;
			}
		}
		return najglosniejszy;
	}
			
}
