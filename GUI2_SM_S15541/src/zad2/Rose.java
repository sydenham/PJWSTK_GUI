package zad2;

class Rose extends Flower {
	public Rose(int count) {
		super(count);
	}

	@Override
	public String getColor() {
		return "czerwony";
	}

	@Override
	public String getName() {
		return "róża";
	}
}