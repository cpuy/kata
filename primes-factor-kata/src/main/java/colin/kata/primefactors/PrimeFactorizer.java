package colin.kata.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizer {

	public List<Integer> factorize(final int number) {
		List<Integer> primes = new ArrayList<Integer>();
		int n = number;
		if (n > 1) {
			if (n % 2 == 0) {
				primes.add(2);
				n /= 2;
			} 
			
			if (n > 1) {
				primes.add(n);
			}
		}
		return primes;
	}

}
