package zad3;

public interface Reversible<T> {
	// podajemy T - GENERICS - jako domyślny typ, że metoda reverse zaimplementowana bedzie zwaracać coś a nie void - nie wiemy
	// co (bo raz double a raz string) więc jakiś tam T
	T reverse();

}
