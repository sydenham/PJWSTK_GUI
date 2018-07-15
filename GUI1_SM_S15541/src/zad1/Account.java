package zad1;

public class Account {
	
	private double balance;
	
	// static bo niezmienna
	private static double interestRate = 1;
	
	public void deposit (double sum) {
		if (sum < 0)
			System.out.println("Operacja niedozowlona");
		else balance = balance + sum;
	}

	public void withdraw (double sum) {
		if ((sum < 0) || (balance < sum))
			System.out.println("Brak wystarczaj�cych �rodk�w na wyp�at� lub operacja niedozwolona");
		else balance = balance - sum;
	}
	
	public void transfer (Account a, double sum) {
		if ((sum < 0) || (balance < sum))
			System.out.println("Brak wystarczaj�cych �rodk�w na przelew lub operacja niedozwolona");
		else {
			balance = balance - sum;
			a.deposit(sum);
		}
	}
	
	public void addInterest () {
		balance = balance + (balance * interestRate);
	}
	
	public static void setInterestRate(double rate) {
		rate = rate / 100;
		interestRate = rate;
	}
	
	//getter
	public double getBalance() {
		return balance;
	}
	
	
}
