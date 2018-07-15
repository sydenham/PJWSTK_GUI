package zad2;

import java.util.HashMap;

public final class PriceList extends HashMap<String, Double> {
	

	private static PriceList INSTANCE = null;

	// prywatny konstruktor - nie można się do niego odwołać
	private PriceList(){
	}
	
	//singleton - jedna lista; poniżej - getInstance
	//skoro konstruktor prywatny, to metodą tworzymy jedyną instancję, lu - jeśli jest - zwracamy istniejącą
	public final static PriceList getInstance(){
		if (INSTANCE == null){
			INSTANCE = new PriceList();
		}
		return INSTANCE;
	}

}


