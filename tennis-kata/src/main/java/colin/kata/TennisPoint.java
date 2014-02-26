package colin.kata;


public enum TennisPoint {

	LOVE, FIFTEEN, THIRTY, FOURTY;
	
	public TennisPoint increment() {
		if (this.equals(FIFTEEN)) {
			return THIRTY;
		} else if (this.equals(THIRTY)) {
			return FOURTY;
		} else {
			return FIFTEEN;
		}
	}
}