package colin.kata.codegen.parser;

import java.util.List;

import colin.kata.codegen.Message;
import colin.kata.codegen.MessageTag;
import colin.kata.codegen.validator.InvalidFormatExeption;

public class MessageParser {

	public Message parse(List<String> lines) throws InvalidFormatExeption {
		validateFormat(lines);
		
		Message message = new Message();
		for (String line : lines) {
			if (describe(MessageTag.DATANAME, line)) {
				message.setDataName(extract(line, MessageTag.DATANAME));
			} else if (describe(MessageTag.COMMENT, line)) {
				message.addComment(extract(line, MessageTag.COMMENT));
			}  else if (describe(MessageTag.FIELD, line)) {
				message.addField(parseField(line));
			}
		}
		return message;
	}

	private void validateFormat(List<String> lines) throws InvalidFormatExeption {
		if (!describe(MessageTag.END, lastLine(lines))) {
			throw new InvalidFormatExeption("Message must end with a E tag");
		}
		for (String string : lines) {
			if (describe(MessageTag.DATANAME, string)) {
				break;
			}
			if (!describe(MessageTag.COMMENT, string)) {
				throw new InvalidFormatExeption("Message must start with a D tag, or have optionnal comments");
			}
		}
	}

	private Field parseField(String line) {
		String field = extract(line, MessageTag.FIELD);
		String[] split = field.split("\\s");
		return new Field(split[0].trim(), FieldType.valueOf(split[1].toUpperCase()));
	}
	
	private String lastLine(List<String> lines) {
		return lines.get(lines.size() - 1);
	}

	private boolean describe(MessageTag tag, String line) {
		return line.contains(tag.toString());
	}

	private String extract(String line, MessageTag tag) {
		return line.replaceFirst(tag.toString(), "").trim();
	}

}
