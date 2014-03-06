package colin.kata.primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizer {

	public List<Integer> factorize(final int number) {
		List<Integer> primes = new ArrayList<Integer>();
		if (number > 1) {
			if (number % 2 == 0) {
				primes.add(2);
				primes.addAll(factorize(number / 2));
			} else {
				primes.add(number);
			}
		}
		return primes;
	}

}
