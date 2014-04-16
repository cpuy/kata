package colin.kata.codegen.strategy;

import static java.lang.System.lineSeparator;
import colin.kata.codegen.Message;

public class DartStrategy implements GenerationStrategy {

	public String generate(Message message) {
		StringBuilder builder = new StringBuilder();
		builder.append(comments(message));
		builder.append("class ").append(message.getDataName()).append(" {").append(lineSeparator()).append("}");
		return builder.toString();
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
