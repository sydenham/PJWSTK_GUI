package zad3;

public class ReversibleDouble implements Reversible<Double> {

	Double number;
	

	public ReversibleDouble (int number){
		this.number = (double) number;
	}
	
	public Double reverse(){
		return number = 1 / number;
	}
	
	public Double add10(){
		return number = number + 10;
	}
	
	
	public String toString(){
		return number.toString();
	}

}
