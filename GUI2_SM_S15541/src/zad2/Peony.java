package zad2;


class Peony extends Flower {
	public Peony(int count) {
		super(count);
	}

	@Override
	public String getColor() {
		return "czerwony";
	}

	@Override
	public String getName() {
		return "piwonia";
	}
}