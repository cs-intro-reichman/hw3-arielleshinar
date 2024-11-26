// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  

	


	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		//turn the precent into a number to calc
		rate = (rate/100) +1;
		//payment a month is total amount divided by n times the interest
		payment = (loan/n)*rate;
		// a loop n times that subtracts the payment until the ending balance (near 0)
		for(int i=0; i<n; i++){

			loan = loan - payment;
		}
		return loan;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		
		iterationCounter = 0;
		//beacuse of the interest rate we know that for loan/g the end balance will be >0
		double g = loan/n;
		//turn the precent into a number to calc
		rate = (rate/100) +1;
		//payment a month is total amount divided by n times the interest
		double payment = g*rate;
		double newSum = loan;
		
		//loop that checks if the endbalance is nonnegtive 
		while (newSum >=0){
			iterationCounter++ ;
			g = g + epsilon;
			// a loop that happens n times to check if the g is correct
			for(int i =0; i < n; i++){
				iterationCounter++;
				newSum -= payment; 
			}
		}
		return g;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  

		iterationCounter = 0;
		//beacuse of the interest rate we know that for loan/g the end balance will be >0
		double l = loan/n;
		double h = loan;
		double g = (l+h) / 2.0;
		//turn the precent into a number to calc
		rate = (rate/100) +1;
		//payment a month is total amount divided by n times the interest
		double paymentL = l*rate;
		double paymentG = g*rate;
		double newSumL = loan;
		double newSumG = loan;
		
			while ((h-l) > epsilon ){
				//loops that check the f(l) and f(g)
				for(int i = 0; i < n; i++){
					iterationCounter++;
					newSumL -= paymentL; 
				}
				for(int i = 0; i < n; i++){
					iterationCounter++;
					newSumG -= paymentG; 
				}
				if (newSumG * newSumL > 0){
					l = g;
				} else{
					h = g;
					g=((l+h) / 2.0);
				}
					iterationCounter++;
				}
			
		return g;
    }
}