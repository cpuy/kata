package colin.kata.codegen.strategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

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
	
	@Test
	public void should_add_comments_on_top() throws Exception {
		String expected = "/**\n * This is a comment\n */\nclass Product {\n}";
		
		Message message = new Message();
		message.setDataName("Product");
		message.addComment("This is a comment");
		
		String generated = new DartStrategy().generate(message);
		
		assertThat(generated).isEqualTo(expected);
	}
}
