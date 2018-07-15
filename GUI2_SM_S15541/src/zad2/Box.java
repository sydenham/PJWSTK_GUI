package zad2;

class Box extends FlowerList {
	
	//dziedziczy po FlowerList - musi mieć konstruktor z super, żeby wywołać ten konstruktor zrobiony w FlowerList - inaczej
	// wywoła domyśny, z FloweList który nie istnieje
	public Box(Customer owner) {
		super(owner);
	}
	
	public String toString() {
		// super. ściąga toString z FlowerList i dodaje "pudełko"
		return "Pudełko " + super.toString();
	}
}