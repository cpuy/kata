package colin.kata.codegen;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


public class MessageParserTest {

	@Test
	public void should_parse_comments() throws Exception {
		MessageParser parser = new MessageParser();
		
		Message message = parser.parse("# this is a comment");
		
		assertThat(message.getComment()).isEqualTo("this is a comment");
	}
}
