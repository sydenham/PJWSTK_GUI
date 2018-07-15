package zad2;

class Lilac extends Flower {
	public Lilac(int count) {
		super(count);
	}

	@Override
	public String getColor() {
		return "biały";
	}

	@Override
	public String getName() {
		return "bez";
	}
}