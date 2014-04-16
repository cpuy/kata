package colin.kata.codegen.strategy;

import colin.kata.codegen.Message;

public interface GenerationStrategy {

	public String generate(Message message);
}
