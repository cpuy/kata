package colin.kata.primefactors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FactorizeStep {

	private PrimeFactorizer primeFactorizer;
	private List<Integer> primes;

	@Given("a primeFactorizer") 
	public void hereIsThePrimeFactorizer() {
		primeFactorizer = new PrimeFactorizer();
	}
	
	@When("I ask prime factors for $number")
	public void factorize(int number) {
		primes = primeFactorizer.factorize(number);
	}
	
	@Then("prime factor should be $number")
	public void primeFactorShouldBe(int number) {
		assertThat(primes).containsOnly(number);
	}
	
	@Then("prime factors should be $list")
	public void primeFactorsShouldBe(List<Integer> list) {
		assertThat(primes).hasSameSizeAs(list).containsAll(list);
	}
}
