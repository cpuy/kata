package colin.kata;


public enum TennisPoint {

	LOVE, FIFTEEN, THIRTY, FOURTY, WIN, 
	DEUCE, ADVANTAGE;
	
	public TennisPoint increment() {
		if (this == ADVANTAGE) {
			return WIN;
		}
		return values()[ordinal() + 1];
	}
}
