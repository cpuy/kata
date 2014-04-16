package colin.kata.codegen.strategy;

import static colin.kata.codegen.parser.MessageBuilder.aMessage;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import colin.kata.codegen.Message;
import colin.kata.codegen.parser.MessageBuilder;


public class DartStrategyTest {

	private DartStrategy strategy;

	@Before
	public void setUp() {
		strategy = new DartStrategy();
	}
	
	@Test
	public void should_generate_class_structure() throws Exception {
		String expected = "class Product {\n}";
		Message message = aMessage().withDataName("Product").build();
		
		String generated = strategy.generate(message);
		
		assertThat(generated).isEqualTo(expected);
	}
	
	@Test
	public void should_add_comments_on_top() throws Exception {
		String expected = "/**\n * This is a comment\n * This is another comment\n */\nclass Product {\n}";
		Message message = aMessage().withDataName("Product")
				.withComment("This is a comment")
				.withComment("This is another comment").build();
		
		String generated = strategy.generate(message);
		
		assertThat(generated).isEqualTo(expected);
	}
	
	@Test
	public void should_add_fields_in_class_body() throws Exception {
		
	}
	
}
