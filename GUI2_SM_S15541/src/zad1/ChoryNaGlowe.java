package zad1;

public class ChoryNaGlowe extends Pacjent {
	
	ChoryNaGlowe(String name){
		super(name);
	}

	public String choroba(){
		return "głowa";
	}
	
	public String leczenie(){
		return "aspiryna";
	}
}
