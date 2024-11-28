// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// create a loop that adds 1 to x1 x2 times to add x1 and x2
		int plusResult = x1;
		//checks if one of the integers i got is 0 , if so returns the other one
		if (x1 == 0 || x2 == 0){
			if (x1 == 0){
				plusResult = x2;
			}
			if (x2 == 0){
				plusResult = x1;
			}	
		}else { //if one or both of x1 and x2 are negative
			if (x1 < 0 || x2 <0){
	
				if (x1 < 0){
					plusResult = x2;
					for (int i = 1; i <= Math.abs(x1); i++){
					plusResult --;
					}
				}

				if (x2 < 0){
					plusResult = x1;
					for (int i = 1; i <= Math.abs(x2); i++){
					plusResult --;
					}
				}
			}
			else { // if x1 and x2 are bothe positive
				plusResult = x1;
				//adds 1 to x1 until i = x2
				for (int i = 1; i <= x2; i++){
					plusResult ++;
				}	
		
			}
		}
		return plusResult;
	}


	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// if one of them is 0:
		int minusResult = x1;
		if (x1 == 0 || x2 == 0){
			if (x1 == 0){
				minusResult = x2;
			}
			if (x2 == 0){
				minusResult = x1;
			}	
		}
		else{ //if one or both of x1 and x2 are negative
			if (x1 < 0 || x2 <0){
	
				if (x1 < 0){
					minusResult = x1;
					for (int i = 1; i <= Math.abs(x1); i++){
					minusResult --;
					}
				}

				if (x2 < 0){
					minusResult = x1;
					for (int i = 1; i <= Math.abs(x2); i++){
					minusResult ++;
					}
				}
			}
			else{//both are positive
				minusResult = x1;
				for (int i = 1; i <= x2; i++){
					minusResult --;
				}
			}
		}
		return minusResult;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// create veriables for the first counter and total counter
		
		int totalCount = 0;
		//special if one of the inputs is zero
		if (x1 == 0 || x2 == 0){
			
			totalCount = 0;
		}
		else {// if one of the inputs is negativ
			if (x1 < 0 || x2 < 0){

				//if both ints are negative
				if (x1 < 0 && x2 < 0){
					totalCount = Math.abs(x1);
					
					
					//outer loop gets the inner loop to add x1 to x1 x2 times
					for (int i = 1; i < Math.abs(x2); i++){
						

						//inner loop that adds x1 to x1 once
						for (int j = 1; j <= Math.abs(x1); j++){
							
							totalCount++;
						}
					}

				} else {//if one of them is negative
					if (x1<0){
						totalCount = x1;
						//outer loop gets the inner loop to add x1 to x1 x2 times
						for (int i = 1; i < Math.abs(x2); i++){
					
							//inner loop that adds x1 to x1 once
							for (int j = 1; j <= Math.abs(x1); j++){
								//innerCount++;
								totalCount--;
							}				
						}
					}
					else{//if x2 <0
						totalCount = x2;
						//outer loop gets the inner loop to add x1 to x1 x2 times
						for (int i = 1; i < Math.abs(x1); i++){
					
							//inner loop that adds x1 to x1 once
							for (int j = 1; j <= Math.abs(x2); j++){
								//innerCount++;
								totalCount--;
							}							
						}
					}

				}
			}
			else {//if both are positive
					//sice both are positive add inside both the loops 
					totalCount = x1;	
					//outer loop gets the inner loop to add x1 to x1 x2 times
					for (int i = 1; i < x2; i++){
						
						//inner loop that adds x1 to x1 once
						for (int j = 1; j <= x1; j++){
							
							totalCount++;
						}
					}
			}
	
		}
		return totalCount;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		//special case if n=0
		int powResult = 0;
		if (n == 0){
			powResult = 1;
		}
		else{ // uses the function times to multiply the x by x n times
					
				powResult = x;
				for (int i=1; i < n; i++){
					powResult = times(powResult, x);
				} 
			}
			return powResult;
		}
		
	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int divideResult = 0;
		int checker = 0;
		// if x1 equals zero
		if (x1 == 0 ){
			if (x1==0){
				
				divideResult = 0;
			}
		}else{ 
			//positive numbers
			if (x1 > 0 && x2 > 0){
				divideResult = x1;
				
				while (times(x2,divideResult) != x1){
					divideResult--;
					checker = times(divideResult,x2);
					if (minus(x1,checker) < x2 && minus(x1,checker) > 0)
					break;
				}
			}

			else{
				//if both are negative:
				if (x1 < 0 && x2 < 0){
					
						divideResult = Math.abs(x1);
						
							while (times(x2,divideResult) != x1){
								divideResult--;
								checker = times(divideResult,x2);
								if (minus(x1,checker) < x2 && minus(x1,checker) > 0)
								break;
							}
				}		

						
				//if x1 < 0
				if (x1 < 0){
					divideResult = x1;
						while (times(x2,divideResult) != x1){
							divideResult++;
							checker = times(divideResult,x2);
							if (minus(x1,checker) < x2 && minus(x1,checker) > 0)
							break;
						
						}
						

				}
				//if x2 < 0
				if (x2 < 0){
					divideResult = x1;
						while (times(x2,divideResult) != x1){
							divideResult--;
							checker = times(divideResult,x2);
							if (minus(x1,checker) < x2 && minus(x1,checker) > 0)
								break;
						}
					}
				}
		}

		return divideResult;
	}


	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// special case for 0
		int modResult = 0;
		int calc = 0;
		if (x1 == 0 ){
			modResult = 0;
		}
		
		if (x1 < x2){
			modResult = x1;
		}
		
		else {//if it divides for example 120 mod 6
			calc = div(x1,x2);
			if ( x1 == times(calc, x2)){
			modResult = 0;
			}
			else{
				modResult = minus(x1, times(calc, x2));
			}
		}
		
		return modResult;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {

			int shoresh = 1;
			int check = 0;

			if (x == 0){
				shoresh = 0;
			}else{
				
				while (times(check, check) < x && times(shoresh,shoresh) < x){	
					check++ ;
					shoresh++ ;
				}
				if (x > times(check,check) && x < times(shoresh,shoresh)){
					shoresh = check;
				}
			}
		return shoresh;
	}	 
}