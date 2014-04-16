package colin.kata.codegen.parser;

public class Field {

	private String name;
	private FieldType fieldType;

	public Field(String name, FieldType fieldType) {
		this.name = name;
		this.fieldType = fieldType;
	}

	public String getName() {
		return name;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fieldType == null) ? 0 : fieldType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Field other = (Field) obj;
		if (fieldType != other.fieldType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Field [name=" + name + ", integer=" + fieldType + "]";
	}

}
