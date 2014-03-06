package colin.kata.primefactors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import colin.kata.primefactors.FactorizationException;
import colin.kata.primefactors.PrimeFactorizer;

public class PrimeFactorsTest {

	private PrimeFactorizer primeFactorizer;

	@Before
	public void initFactorizer() {
		primeFactorizer = new PrimeFactorizer();
	}
	
	@Test(expected = FactorizationException.class)
	public void prime_factorization_cannot_be_applied_to_a_number_smaller_than_2() throws Exception {
		primeFactorizer.factorize(1);
	}
	
	@Test
	public void prime_factors_of_2_is_2() throws Exception {
		List<Integer> primeFactors = primeFactorizer.factorize(2);
		
		assertThat(primeFactors).containsOnly(2);
	}
}
