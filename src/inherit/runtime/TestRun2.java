package inherit.runtime;

/**
  RBI : parent class 
       - createAcc()
       - processLoan()  9% ROI
       
  HDFC : Child class of  RBI
       - demat()
       - processLoan()  12% ROI
       
  SBI : Child class of  RBI
       - processLoan()  10% ROI
       
  ICICI : Child class of  RBI
       - processLoan()  11% ROI
       
 *
 */
public class TestRunOK2 {
	public static void main(String[] args) {
		RBI r = new Hdfc();// create obj for HDFC and refer by RBI
		r.createAcc();  //RBI
		r.processLoan();  //Hdfc

		
		
		r = new Icici(); // create obj for Icici and refer by RBI
		r.createAcc();//RBI
		r.processLoan();//Icici
		
		
		
		r= new SBI() ;// create obj for SBI and refer by RBI
		r.createAcc();//RBI
		r.processLoan();//SBI
	}
}

//r can refer to hdfc obj or icici obj or sbi obj
// r.processLoan() from class the logic is executed can be predicted only at runtime...
// that depends on the object pointed by r.

