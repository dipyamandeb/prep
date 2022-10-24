package study.nse;

import java.util.HashMap;
/**
 * 
 * @author dipyamand
 * Fibronacci with memoization
 */
public class SolutionFibonacci {

	public static void main(String[] args) {
		long number = 7;
		System.out.println("Fib of " + number + " is : " + fib(number));
	}

	private static HashMap<Long, Long> hm = new HashMap<Long, Long>();

	private static Long fib(Long number) {
		if (number == 0 || number == 1) {
			return number;
		}

		Long fibNumber = hm.get(number);
		if (fibNumber == null) {
			fibNumber = fib(number - 1) + fib(number - 2);
			System.out.println(number + " " + fibNumber);
			hm.put(number, fibNumber);
		}
		return fibNumber;
	}

}
