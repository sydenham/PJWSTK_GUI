package zad2;

abstract class Flower {
	
	private int count;

	public Flower(int count) {
		this.count = count;	
	}
	
	public int getCount() {
		return count;
	}
	
	public abstract String getColor();
	
	public abstract String getName();
	
	public final double getPrice() {
		// bierzemy  jedyną instancję Pricelisty (bo to singleton) i bierzemy get dany kwiatek-key na Mapie (PriceList to mapa)
		//a getName daje nam właście ten kwiatek, np. PriceList.getInstance().get(Rose); - Rose to key a value to cena róży
		Double price = (Double) PriceList.getInstance().get(getName());
		return price == null ? -1 : price;	
	}
	
	public String toString() {
		return getName() + ", kolor: " + getColor() + ", ilosc " + 
			   getCount() + ", cena " + getPrice();
	}
}