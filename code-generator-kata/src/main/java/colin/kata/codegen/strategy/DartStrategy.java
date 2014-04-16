package colin.kata.codegen.strategy;

import static java.lang.System.lineSeparator;
import colin.kata.codegen.Message;
import colin.kata.codegen.parser.Field;
import colin.kata.codegen.parser.FieldType;

public class DartStrategy implements GenerationStrategy {

	public String generate(Message message) {
		StringBuilder builder = new StringBuilder();
		builder.append(comments(message));
		builder.append("class ").append(message.getDataName()).append(" {").append(lineSeparator());
		for (Field field : message.getFields()) {
			builder.append("\t").append(convert(field.getFieldType())).append(" ").append(field.getName()).append(";").append(lineSeparator());
		}
		builder.append("}");
		return builder.toString();
	}
	
	private String convert(FieldType type) {
		if (FieldType.INTEGER.equals(type)) {
			return "int";
		}
		if (FieldType.TEXT.equals(type)) {
			return "String";
		}
		throw new RuntimeException("Unknown fieldType");
	}

	private String comments(Message message) {
		if (!message.hasComments()) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		builder.append("/**").append(lineSeparator());
		for (String comment : message.getComments()) {
			builder.append(" * ").append(comment).append(lineSeparator());
		}
		builder.append(" */").append(lineSeparator());
		return builder.toString();
	}

}
