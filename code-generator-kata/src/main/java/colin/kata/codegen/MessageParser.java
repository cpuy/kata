package colin.kata.codegen;

import java.util.List;

public class MessageParser {

	private static final String END = "E";
	private static final String COMMENT = "#";
	private static final String DATANAME = "D";
	private static final String FIELD = "F";

	public Message parse(List<String> lines) throws InvalidFormatExeption {
		if (!describe(END, lastLine(lines))) {
			throw new InvalidFormatExeption("Message must end with a E tag");
		}
		for (String string : lines) {
			if (describe(DATANAME, string)) {
				break;
			}
			if (!describe(COMMENT, string)) {
				throw new InvalidFormatExeption("Message must start with a D tag, or have optionnal comments");
			}
		}
		
		Message message = new Message();
		for (int i = 0; !lines.get(i).contains(END); i++) {
			String line = lines.get(i);
			if (describe(DATANAME, line)) {
				message.setDataName(extract(line, DATANAME));
			} else if (describe(COMMENT, line)) {
				message.addComment(extract(line, COMMENT));
			}  else if (describe(FIELD, line)) {
				message.addField(parseField(line));
			}
		}
		return message;
	}

	private Field parseField(String line) {
		String field = extract(line, FIELD);
		String[] split = field.split("\\s");
		return new Field(split[0].trim(), FieldType.valueOf(split[1].toUpperCase()));
	}
	
	private String lastLine(List<String> lines) {
		return lines.get(lines.size() - 1);
	}

	private boolean describe(String tag, String line) {
		return line.contains(tag);
	}

	private String extract(String line, String tag) {
		return line.replaceFirst(tag, "").trim();
	}

}
