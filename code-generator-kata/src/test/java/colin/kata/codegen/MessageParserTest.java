package colin.kata.codegen;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class MessageParserTest {

	private MessageParser parser;

	@Before
	public void setUp() {
		parser = new MessageParser();
	}

	@Test(expected = InvalidFormatExeption.class)
	public void should_begin_with_a_D_tag() throws Exception {
		parser.parse(asList("H this is an unknow tag"));
	}
	
	@Test
	public void should_parse_data_name() throws Exception {
		Message message = parser.parse(Arrays.asList("D dataName"));
		
		assertThat(message.getDataName()).isEqualTo("dataName");
	}

	@Test
	public void might_have_one_or_several_comments_before_message_start() throws Exception {
		Message message = parser.parse(asList("# this is a comment", "# this is another comment", "D dataName"));

		assertThat(message.getComments()).containsExactly("this is a comment", "this is another comment");
	}

	// @Test
	// public void should_parse_comments() throws Exception {
	// parser = new MessageParser();
	//
	// Message message = parser.parse(asList("# this is a comment"));
	//
	// assertThat(message.getComment()).isEqualTo("this is a comment");
	// }
	//
	// @Test
	// public void should_parse_data_name() throws Exception {
	// parser = new MessageParser();
	//
	// Message message = parser.parse(asList("# this is a comment", "D dataName"));
	//
	// assertThat(message.getDataName()).isEqualTo("dataName");
	// }
}
