package colin.kata.codegen.strategy;

import static java.lang.System.lineSeparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import colin.kata.codegen.Message;
import colin.kata.codegen.parser.Field;
import colin.kata.codegen.parser.FieldType;

public class DartStrategy implements GenerationStrategy {

	public String generate(Message message) {
		StringBuilder builder = new StringBuilder();
		builder.append(comments(message));
		builder.append("class ").append(message.getDataName()).append(" {").append(lineSeparator());
		builder.append(fields(message));
		builder.append("}");
		return builder.toString();
	}

	private String fields(Message message) {
		StringBuilder builder = new StringBuilder();
		HashMap<FieldType, List<Field>> map = new LinkedHashMap<FieldType, List<Field>>();
		for (Field field : message.getFields()) {
			List<Field> list = map.get(field.getFieldType());
			if (list == null) { list = new ArrayList<Field>(); map.put(field.getFieldType(), list); }
			list.add(field);
		}
		for (FieldType type : map.keySet()) {
			builder.append("\t").append(convert(type));
			for (Field f : map.get(type)) {
				builder.append(" ").append(f.getName()).append(",");
			}
			builder.deleteCharAt(builder.length() - 1);
			builder.append(";").append(lineSeparator());
		}
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
