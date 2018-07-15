package zad1;

public class BankCustomer {

	private Person name;
	
	// od razu ma konto, tworzy mu się obiekt konto
	private Account account = new Account();

	
	BankCustomer (Person name) {
		this.name = name;
		
	}
	
	
	public Account getAccount() {
		return account;		
	}
	
	// przedefiniowanie metody toString
	public String toString(){
		return "Klient " + name + " stan konta " + account.getBalance();
	}

}
