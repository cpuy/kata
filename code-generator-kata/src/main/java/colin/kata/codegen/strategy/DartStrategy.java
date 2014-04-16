package colin.kata.codegen.strategy;

import colin.kata.codegen.Message;


public class DartStrategy implements GenerationStrategy {

	public String generate(Message message) {
		StringBuilder builder = new StringBuilder();
		builder.append("class ").append(message.getDataName()).append(" {").append(System.lineSeparator()).append("}");
		return builder.toString();
	}

}
