package colin.kata.primefactors;

import static java.util.Arrays.asList;

import java.util.List;

public class PrimeFactorizer {

	public List<Integer> factorize(int number) throws FactorizationException {
		if (number < 2) {
			throw new FactorizationException("Number less than two cannot be factorized");
		}
		return asList(number);
	}

}
