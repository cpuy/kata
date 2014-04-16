package colin.kata.codegen.parser;

import colin.kata.codegen.Message;

public class MessageBuilder {

	private Message message = new Message();
	
	public static MessageBuilder aMessage() {
		return new MessageBuilder();
	}

	public MessageBuilder withDataName(String dataName) {
		message.setDataName(dataName);
		return this;
	}
	
	public MessageBuilder withComment(String comment) {
		message.addComment(comment);
		return this;
	}
	
	public Message build() {
		return message;
	}
}
