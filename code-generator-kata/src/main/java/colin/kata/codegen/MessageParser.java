package colin.kata.codegen;

import java.util.Arrays;
import java.util.List;

public class MessageParser {


	private static final String TAG_DATANAME = "D";

	public Message parse(List<String> lines) throws InvalidFormatExeption {
		Message message = new Message();
		for (String string : lines) {
			if (!describeDataName(string)) {
				if (string.contains("#")) {
					message.addComment(string.replaceAll("#", "").trim());
				} else {
					throw new InvalidFormatExeption("Message must start with a D tag");
				}
			} else {
				message.setDataName(string.replaceAll("D", "").trim());
			}
		}
		return message;
	}

	private boolean describeDataName(String line) {
		return line.contains(TAG_DATANAME);
	}


}
