package zad2;

import java.util.Iterator;

class Customer {
	private String name;
	private int money;
	//każdy ma wózek
	private ShoppingCart cart;
	
	public Customer(String name, int money) {
		this.name = name;
		this.money = money;
		//konstruktor od razu robi shoppingCart (this) - TEN Customer owner (klasa FlowerList)
		this.cart = new ShoppingCart(this);
	}
	public String getName() {
		return name;
	}
	public int getCash() {
		return money;
	}
	public void get(Flower f) {
		cart.add(f);
	}
	public ShoppingCart getShoppingCart() {
		return cart;
	}
	public void pay() {
		//iterator zawierać będzie obiekty Flower i wywołujemy na wózku metodę interator - możemy bo jest iterable z zasady bo jest listą
		// inaczej musielibyśmy go zrobić iterable jak w GUI3 zad 1
		//gdyby nie potrzeba remove() to w ogóle iterator nie był potrzebny, bo cart czy box są iterable bo są listami i możnaby zrobić 
		// for (Flower flower : cart) / while i next / hasNext / remove wymagają klasy Iterator
		// Iterator zwany kursorem - BO WSKAZUJE na kolejne obiekty kolekcji
		//Od wersji 1.2 interfejs java.util.Iterator umożliwia iterowanie po kolekcjach. Każdy Iterator posiada metody next() i hasNext(), 
		//oraz opcjonalnie może implementować metodę remove(). Iteratory tworzone są metodą iterator() odpowiedniej klasy kolekcji.
		//Metoda next() przesuwa iterator i zwraca wartość, na którą wskazuje iterator. Zaraz po utworzeniu iterator wskazuje 
		//na specjalną wartość przed pierwszym elementem, tak by pierwszy element był pobrany przy pierwszym wywołaniu next(). 
		//Do sprawdzenia, czy odwiedzono wszystkie elementy kolekcji stosuje się metodę hasNext(). 
		// iterator() - Returns an iterator over a set of elements of type T, if Iterator<T>
		// iter to iterator, a więc trafia do pętli while i idzie od przed pierwszego elementu 
		//stąd iter.next - bierze po raz pierwszy, pierwszy element z listy, bo najpierw robi się hasnext i sprawdza czy w ogóle jest jakiś element
		
		Iterator<Flower> iter = cart.iterator();
		while (iter.hasNext()) {
			Flower flower = iter.next();
			double price = flower.getPrice();
			if (price == -1) {
				iter.remove();
			} else {
				double totalPrice = price * flower.getCount();
				if (money >= totalPrice) {
					money -= totalPrice;
				} else {
					iter.remove();
				}
			}
		}
	}
	public void pack(Box box) {
		box.addAll(cart);
		cart.clear();
	}
}
	