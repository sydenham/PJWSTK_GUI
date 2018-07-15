package zad2;



class ShoppingCart extends FlowerList {
	
	public ShoppingCart(Customer owner) {
		super(owner);
	}	
	
	public String toString() {
		return "Wózek " + super.toString();
	}
}