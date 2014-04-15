package colin.kata.codegen;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;

public class MessageParser {


	public Message parse(String string) {
		String comment = string.replaceAll("#", "").trim();
		return new Message(comment);
	}


}
