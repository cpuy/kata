package colin.kata.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizer {

	public List<Integer> factorize(final int number) {
		List<Integer> primes = new ArrayList<Integer>();
		int n = number;
		if (n > 1) {
			int prime = 2;
			
			while (prime <= n) {
				if (n % prime == 0) {
					primes.add(prime);
					n /= prime;
				} 
				prime++;
			}
		}
		return primes;
	}

}
