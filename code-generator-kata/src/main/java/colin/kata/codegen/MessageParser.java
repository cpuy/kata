package colin.kata.codegen;

import java.util.List;

public class MessageParser {

	private static final String END = "E";
	private static final String COMMENT = "#";
	private static final String DATANAME = "D";

	public Message parse(List<String> lines) throws InvalidFormatExeption {
		if (!describe(END, lastLine(lines))) {
			throw new InvalidFormatExeption("Message must end with a E tag");
		}
		Message message = new Message();
		for (int i = 0; !lines.get(i).contains(END); i++) {
			String line = lines.get(i);
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

	private String lastLine(List<String> lines) {
		return lines.get(lines.size() - 1);
	}

	private boolean describe(String tag, String line) {
		return line.contains(tag);
	}

	private String extract(String line, String tag) {
		return line.replace(tag, "").trim();
	}

}
