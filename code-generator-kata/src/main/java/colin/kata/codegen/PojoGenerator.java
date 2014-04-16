package colin.kata.codegen;

import static java.util.Arrays.asList;

import java.util.List;

import colin.kata.codegen.parser.InvalidFormatExeption;
import colin.kata.codegen.parser.MessageParser;
import colin.kata.codegen.strategy.GenerationStrategy;

public class PojoGenerator {

	private MessageParser parser;
	private GenerationStrategy strategy;

	public PojoGenerator(MessageParser parser, GenerationStrategy strategy) {
		this.parser = parser;
		this.strategy = strategy;
	}

	public String generate(String data) throws InvalidFormatExeption {
		Message message = parser.parse(split(data));
		return strategy.generate(message);
	}

	private List<String> split(String data) {
		String[] split = data.split(System.lineSeparator());
		return asList(split);
	}

}
