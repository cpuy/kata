package colin.kata.primefactor;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeFactorsTest {

	@Test(expected = FactorizationException.class)
	public void prime_factorization_cannot_be_applied_to_a_number_smaller_than_2() throws Exception {
		new PrimeFactorizer().factorize(1);
	}
}
