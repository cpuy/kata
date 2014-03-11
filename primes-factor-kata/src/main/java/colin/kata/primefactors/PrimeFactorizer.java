package colin.kata.primefactors;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorizer {

	public List<Integer> factorize(final int number) {
		Factorizable factorizable = new Factorizable(number);
		if (factorizable.canBeFactorized()) 
			return factorize(factorizable);
		else
			return emptyList();
	}

	private List<Integer> factorize(Factorizable factorizable) {
		List<Integer> primes = new ArrayList<Integer>();
		int prime = 2;
		while (factorizable.greaterOrEqualsThan(prime)) {
			if (factorizable.isFactorizableBy(prime)) {
				primes.add(prime);
				factorizable.factorize(prime);
			} 
			prime++;
		}
		return primes;
	}
}
