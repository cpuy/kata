package colin.kata.codegen;

public enum MessageTag {
	DATANAME("D"), FIELD("F"), END("E"), COMMENT("#");
	
	private String description;

	MessageTag(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return description;
	}
}
