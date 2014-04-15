package colin.kata.codegen;

import java.util.ArrayList;
import java.util.List;

public class Message {

	private List<String> comments = new ArrayList<String>();
	private String dataName;

	public Message() {}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	
	public void addComment(String comment) {
		this.comments.add(comment);
	}
}
