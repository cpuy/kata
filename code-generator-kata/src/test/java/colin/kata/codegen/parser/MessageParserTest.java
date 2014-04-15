package colin.kata.codegen.parser;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import colin.kata.codegen.Message;
import colin.kata.codegen.validator.InvalidFormatExeption;

public class MessageParserTest {

	private MessageParser parser;

	@Before
	public void setUp() {
		parser = new MessageParser();
	}

	@Test(expected = InvalidFormatExeption.class)
	public void should_begin_with_a_D_tag() throws Exception {
		parser.parse(asList("H this is an unknow tag", "E"));
	}
	
	@Test(expected = InvalidFormatExeption.class)
	public void should_end_with_a_E_tag() throws Exception {
		parser.parse(asList("D begin", "A not correctly ended"));
	}

	@Test
	public void should_parse_data_name() throws Exception {
		Message message = parser.parse(Arrays.asList("D dataName", "E"));
		
		assertThat(message.getDataName()).isEqualTo("dataName");
	}

	@Test
	public void might_have_one_or_several_comments_before_message_start() throws Exception {
		Message message = parser.parse(asList("# this is a comment", "# this is another comment", "D dataName", "E"));

		assertThat(message.getComments()).containsExactly("this is a comment", "this is another comment");
	}

	@Test
	public void should_parse_fields() throws Exception {
		Message message = parser.parse(asList("D dataName", "F textField\ttext", "F integerField integer", "E"));

		assertThat(message.getFields()).containsExactly(new Field("textField", FieldType.TEXT), new Field("integerField", FieldType.INTEGER));
	}
}
