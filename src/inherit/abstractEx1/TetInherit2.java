package inherit.abstractEx1;


public class TetInherit2 {
	public static void main(String[] args) { 
		
		//RBIBank r = new RBIBank();// OBJ CANNOT BE CREATED FOR Abstract class

		RBIBank r = new Hdfc();// create obj for child and refer by parent
		
		r.createAccount();// RBI
		r.processLoan(); //RBIBank
		r.createPPF(); //  hdfc
		
	}
}
