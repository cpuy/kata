package colin.kata.codegen.strategy;

import static java.lang.System.lineSeparator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import colin.kata.codegen.Message;
import colin.kata.codegen.parser.Field;
import colin.kata.codegen.parser.FieldType;

public class DartStrategy implements GenerationStrategy {

	public String generate(Message message) {
		StringBuilder builder = new StringBuilder();
		builder.append(comments(message));
		builder.append("class ").append(message.getDataName()).append(" {").append(lineSeparator());
		builder.append(fields(message));
		builder.append(constructor(message));
		builder.append("}");
		return builder.toString();
	}

	private String constructor(Message message) {
		if (message.getFields().isEmpty()) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		builder.append(System.lineSeparator()).append("\t").append(message.getDataName()).append("(");
		for (Field f : message.getFields()) {
			builder.append("this.").append(camelCase(f.getName())).append(", ");
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.deleteCharAt(builder.length() - 1);
		builder.append(");").append(lineSeparator());
		return builder.toString();
	}

	private String fields(Message message) {
		StringBuilder builder = new StringBuilder();
		Map<FieldType, List<Field>> fieldsByType = getFieldsByType(message);
		for (FieldType type : fieldsByType.keySet()) {
			builder.append("\t").append(convert(type));
			for (Field f : fieldsByType.get(type)) {
				builder.append(" ").append(camelCase(f.getName())).append(",");
			}
			builder.deleteCharAt(builder.length() - 1);
			builder.append(";").append(lineSeparator());
		}
		return builder.toString();
	}

	private String camelCase(String name) {
		String[] split = name.split("_");
		String toto = split[0];
		if (split.length > 1) {
			for (int i = 1; i < split.length; i++) {
				String a = split[i];
				char charAt = a.charAt(0);
				toto += String.valueOf(charAt).toUpperCase() + a.substring(1, a.length());
			}
		}
		return toto;
	}
	
	private Map<FieldType, List<Field>> getFieldsByType(Message message) {
		Map<FieldType, List<Field>> fieldsByType = new LinkedHashMap<FieldType, List<Field>>();
		for (Field field : message.getFields()) {
			List<Field> list = fieldsByType.get(field.getFieldType());
			if (list == null) {
				list = new ArrayList<Field>();
				fieldsByType.put(field.getFieldType(), list);
			}
			list.add(field);
		}
		return fieldsByType;
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
