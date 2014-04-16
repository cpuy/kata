package colin.kata.codegen.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import colin.kata.codegen.Message;


public class DartStrategyTest {

	@Test
	public void should_generate_class_structure() throws Exception {
		String expected = "class Product {\n}";
		Message message = new Message();
		message.setDataName("Product");
		
		String generated = new DartStrategy().generate(message);
		
		assertThat(generated).isEqualTo(expected);
	}
}
