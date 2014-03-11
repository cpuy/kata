package colin.kata.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizer {

	public List<Integer> factorize(final int number) {
		List<Integer> primes = new ArrayList<Integer>();
		int n = number;
		if (canBeFactorized(n)) {
			int prime = 2;
			
			while (prime <= n) {
				if (isFactorizable(n, prime)) {
					primes.add(prime);
					n /= prime;
				} 
				prime++;
			}
		}
		return primes;
	}

	private boolean canBeFactorized(int number) {
		return number > 1;
	}

	private boolean isFactorizable(int number, int factor) {
		return number % factor == 0;
	}

}
