package colin.kata.primefactor;

public class PrimeFactorizer {

	public void factorize(int i) throws FactorizationException {
		if (i < 2) {
			throw new FactorizationException("Number less than two cannot be factorized");
		}
	}

}
