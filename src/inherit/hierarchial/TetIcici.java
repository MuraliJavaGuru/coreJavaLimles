package inherit.hierarchial;

public class TetIcici {
	public static void main(String[] args) { 
		// CREATE OBJ FOR ICICI
		Icici icici = new Icici();
		icici.createAccount();
		icici.processLoan(); 
		icici.createPPF();
	}
}

