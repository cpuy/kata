package colin.kata.codegen;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import colin.kata.codegen.parser.Field;

public class Message {

	private List<String> comments = new ArrayList<String>();
	private List<Field> fields = new ArrayList<Field>();
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

	public List<Field> getFields() {
		return fields;
	}

	public void addField(Field field) {
		fields.add(field);		
	}
}
