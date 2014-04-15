package colin.kata.codegen;

import static org.assertj.core.api.Assertions.assertThat;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class GeneratePojoDef {

	private String data;
	private String generatedPojo;

	@Given("^a data structure$")
	public void a_data_structure(String data) throws Throwable {
	    this.data = data;
	}

	@When("^I ask for dart POJO generation$")
	public void I_ask_for_dart_POJO_generation() throws Throwable {
		generatedPojo = new PojoGenerator(new DartStrategy()).generate(data);
	}

	@When("^I ask for java POJO generation$")
	public void I_ask_for_java_POJO_generation() throws Throwable {
		generatedPojo = new PojoGenerator(new JavaStrategy()).generate(data);
	}

	@Then("^I should have the given POJO$")
	public void I_should_have_the_given_POJO(String expectedPojo) throws Throwable {
	    assertThat(expectedPojo).isEqualTo(generatedPojo);
	}
	
	
}
