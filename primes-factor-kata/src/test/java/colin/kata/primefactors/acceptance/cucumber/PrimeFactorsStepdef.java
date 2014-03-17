package colin.kata.primefactors.acceptance.cucumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import colin.kata.primefactors.PrimeFactorizer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PrimeFactorsStepdef {

	private PrimeFactorizer primeFactorizer;
	private int number;

	@Given("^a number")
	public void a_number() {
		primeFactorizer = new PrimeFactorizer();
	}
	
	@When("^number is (\\d+)$")
	public void number_is(int number) {
		this.number = number;
	}
	
	@Then("^prime factor should be (\\d+)$")
	public void prime_factor_should_be(int expectedPrime) {
		List<Integer> primes = primeFactorizer.factorize(number);
		assertThat(primes).containsOnly(expectedPrime);
	}
	
	@Then("^prime factors should be \"(.+)\"")
	public void prime_factors_should_be(List<Integer> expectedPrimes) {
		List<Integer> primes = primeFactorizer.factorize(number);
		assertThat(primes).hasSameSizeAs(expectedPrimes).containsAll(expectedPrimes);
	}
	
}
