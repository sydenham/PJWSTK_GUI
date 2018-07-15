package zad2;

import java.util.LinkedList;

abstract class FlowerList extends LinkedList<Flower> {
	
	private Customer owner;
	
	public FlowerList(Customer owner) {
		this.owner = owner;
	}	
	
	public Customer getOwner() {
		return owner;
	}
	
	public String toString() {
		String result = "własciciel " + getOwner().getName();
		String listResult = "";
		//iterujemy po this - TEJ liscie kwiatów, co oznacza TEN Cart albo TEN Box
		for (Flower f: this) {
			listResult += f + "\n";
		}
		if (!"".equals(listResult)) {
			result += "\n" + listResult.trim();
		} else {
			result += " -- pusto";
		}
		return result;
	}
}