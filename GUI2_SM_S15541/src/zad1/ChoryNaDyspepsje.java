package zad1;

public class ChoryNaDyspepsje extends Pacjent {
	
	public ChoryNaDyspepsje(String name) {
		super(name);
	}

	public String choroba(){
		return "dyspepsja";
	}
	
	public String leczenie(){
		return "węgiel";
	}

}
