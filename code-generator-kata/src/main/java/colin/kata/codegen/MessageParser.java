package colin.kata.codegen;

import java.util.List;

public class MessageParser {

	private static final String COMMENT = "#";
	private static final String DATANAME = "D";

	public Message parse(List<String> lines) throws InvalidFormatExeption {
		Message message = new Message();
		for (String line : lines) {
			if (describe(DATANAME, line)) {
				message.setDataName(extract(line, DATANAME));
			} else if (describe(COMMENT, line)) {
				message.addComment(extract(line, COMMENT));
			} else {
				throw new InvalidFormatExeption("Message must start with a D tag, or have optionnal comments");
			}
		}
		return message;
	}

	private boolean describe(String tag, String line) {
		return line.contains(tag);
	}

	private String extract(String line, String tag) {
		return line.replace(tag, "").trim();
	}

}
