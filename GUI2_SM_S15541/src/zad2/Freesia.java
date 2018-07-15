package zad2;

class Freesia extends Flower {
	public Freesia(int count) {
		super(count);
	}

	@Override
	public String getColor() {
		return "żółty";
	}

	@Override
	public String getName() {
		return "frezja";
	}
}