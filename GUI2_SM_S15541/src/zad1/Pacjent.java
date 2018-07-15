package zad1;

public abstract class Pacjent {
	
	String name = null;
	
	public Pacjent(String name){
		this.name = name;
	}
	
	public String nazwisko(){
		return name;
	}
	
	abstract public String choroba();
	abstract public String leczenie();
	
	// klasa abstrakcyjna - zawiera ststyczne pola oraz zawiera zwykłe i abstrakcyjne metody, które muszą być zainicjowane w klasach dziedziczących
	
	
}
