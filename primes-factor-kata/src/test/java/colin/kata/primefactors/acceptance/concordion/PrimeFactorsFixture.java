package colin.kata.primefactors.acceptance.concordion;

import java.util.List;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import colin.kata.primefactors.PrimeFactorizer;

@RunWith(ConcordionRunner.class)
public class PrimeFactorsFixture {

	private PrimeFactorizer primeFactorizer;

	@Before
	public void setUp() {
		primeFactorizer = new PrimeFactorizer();
	}
	
	public List<Integer> getPrimeFactors(Integer number) {
		return primeFactorizer.factorize(number);
	}
}
